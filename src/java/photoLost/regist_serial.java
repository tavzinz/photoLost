/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package photoLost;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
@WebServlet(name = "regist_serial", urlPatterns = {"/regist_serial"})
public class regist_serial extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //declaração das variaveis do POST
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
	String serial = request.getParameter("serial");
	String mail = request.getParameter("mail");
	String pasta = request.getParameter("pasta");
//        String recompensa = request.getParameter("recompensa");
        
        //declaração das arrayLists para ter os objectos
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        
        Camara CamaraNova = null;
	
        try {
            //leitura das credenciais no ficheiro
            String user = "photolost";
            String pass = "adminlabredes13";
            
            //connecção à BD
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.228.242:3306/photolost",user,pass);
            
            Statement comando = con.createStatement();
            Statement comandoMod = con.createStatement();
            Statement comandoMar = con.createStatement();
            
            //strings para query de todos os objectos
            String queryMaquinasTotal = "SELECT * FROM photolost.camara;";
            String queryModelosTotal = "SELECT * FROM photolost.modelo;";
            String queryMarcasTotal = "SELECT * FROM photolost.marca;";
            
            //executa as querys
            ResultSet res = comando.executeQuery(queryMaquinasTotal);
            ResultSet resMod = comandoMod.executeQuery(queryModelosTotal);
            ResultSet resMar = comandoMar.executeQuery(queryMarcasTotal);
            
            //cria as máquinas e mete-as no array
            while (res.next()){
                Camara a = new Camara();
                //a.marca = res.getInt(marca);
                a.setModelo(res.getInt(2));
                a.setMail(res.getString(3));
                a.setNome(res.getString(1));
                a.setPasta(res.getString(5));
                a.setSerial(res.getString(4));
                
                camaras.add(a);
                
                //debug
                System.out.println("Camara criada id=" + a.getNome());
            }
            
            //cria as marcas e mete-as num array
            while (resMar.next()){
                Marca m = new Marca();
                m.setId(resMar.getInt(1));
                m.setNome(resMar.getString(2));
                
                marcas.add(m);
                
                //debug
                System.out.println("Marca " + m.getNome() + " criada!");
            }
            
            //cria os modelos e mete-os num array
            while (resMod.next()){
                Modelo m = new Modelo();
                m.setId(resMod.getInt(1));
                m.setIdMarca(resMod.getInt(3));
                m.setNome(resMod.getString(2));
                
                modelos.add(m);
                
                //debug
                System.out.println("Modelo " + m.getNome() + " criado!");
            }
            
            //verifica se a camara já existe
            boolean existe = false;
            
            for (Camara a : camaras){
                String srl = a.getSerial();
                if (srl.equals(serial)){
                    existe = true;
                }
            }
            
            //cria máquina nova
            if (existe){
                out.print("A máquina com o número " + serial + " já existe!");
            }else{
                CamaraNova = new Camara();

                //####### MARCA ########################################
                
                //verifica qual é o id da marca da máquina
                Integer idMarca = 0;
                for (Marca m: marcas){
                    if (m.getNome().equals(marca)){
                        idMarca = m.getId();
                        System.out.println("Marca " + m.getNome() + " existente com o id=" + idMarca);
                    }
                }
                
                //regista a nova marca caso ela não exista
                if (idMarca == 0){
                    String registaMarca = "INSERT INTO photolost.marca (nome) VALUES (\'" + marca + "\');";                    
                    String queryidMarca = "SELECT id FROM photolost.marca WHERE nome=\'" + marca + "\';";
                    comando.execute(registaMarca);
                    ResultSet residMarca = comandoMar.executeQuery(queryidMarca);
                    residMarca.next();
                    idMarca = residMarca.getInt(1);
                    //debug
                    System.out.print("Marca " + marca + " criada com o id=" + idMarca + "\n");
                }
                
                //####### MODELO ########################################

                //verifica qual é o id do modelo da máquina
                Integer idModelo = 0;
                for (Modelo mod: modelos){
                    if (mod.getNome().equals(modelo)){
                        idModelo = mod.getId();
                        System.out.println("Modelo " + mod.getNome() + " existente com o id=" + idModelo);
                    }
                }
                
                //regista o novo modelo caso ele não exista
                if (idModelo == 0){
                    String registaModelo = "INSERT INTO photolost.modelo (nome, id_marca) VALUES (\'" + modelo +"\'," + idMarca + ");";
                    
                    System.out.println(registaModelo);
                    
                    String queryidModelo = "SELECT id FROM photolost.modelo WHERE nome=\'" + modelo + "\';";
                    comando.execute(registaModelo);
                    ResultSet residModelo = comandoMod.executeQuery(queryidModelo);
                    residModelo.next();
                    idModelo = residModelo.getInt(1);
                    //debug
                    System.out.print("Modelo " + modelo + " criado com o id=" + idModelo + "\n");
                }
                
                CamaraNova.setModelo(idModelo);
                CamaraNova.setMail(mail);
                CamaraNova.setSerial(serial);
                CamaraNova.setPasta(pasta);
                
                camaras.add(CamaraNova);
                
                //debug
                System.out.println("Camara não existia, uma nova foi criada com o id=" + CamaraNova.getModelo());
            }
            
            //regista a camara nova na base de dados
            if (CamaraNova != null){
                String regMarca = "INSERT INTO photolost.camara (id_modelo, mail, serial, shared_folder) VALUES (" + CamaraNova.getModelo() + ",\'" + CamaraNova.getMail() + "\',\'" + CamaraNova.getSerial() + "\',\'" + CamaraNova.getPasta() + "\');";
                
                //debug
                System.out.println(regMarca);
                
                comando.execute(regMarca);
                //feedback sucesso
                //out.print("Nova camara registada com sucesso");
                //reencaminha para página encontrada.jsp
                System.out.println("Reencaminha para a pagina de confimação.");
                String nextJSP = "/registada.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.forward(request,response);
            }
            
        }catch (Exception e){
            //feedback de erro
            out.print("Erro nas querys: " + e);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
