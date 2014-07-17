package photoLost;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "search_serial", urlPatterns = {"/search_serial"})
public class search_serial extends HttpServlet {

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
        try {
            String serial = request.getParameter("serial");
            String mail = request.getParameter("mail");                         //se hover um parametro de mail, então é para fazer insert
            Integer resultado = null;
            
            if(mail==null){
                //log
                System.out.println("search_serial: Mail não inserido, logo é para procurar máquina.");
                resultado = db.query(serial);
            }else{
                //log
                System.out.println("search_serial: Mail inserido, logo é para registar nova máquina.");
                
                //cria um array com os parametros recebidos
                ArrayList<String> a = new ArrayList<String>();
                String Modelo = request.getParameter("modelo");
                a.add(Modelo);
                String Mail = request.getParameter("mail");
                a.add(Mail);
                String Nome = request.getParameter("nome");
                a.add(Nome);
                String Pasta = request.getParameter("pasta");
                a.add(Pasta);
                String Serial = request.getParameter("serial");
                a.add(Serial);
                String Recompensa = request.getParameter("recompensa");
                a.add(Recompensa);
                
                db.query(a);
            }
            
            /*valores de retorno
                se a camara existe: 1
                se a camara não existe: 2
                se a camara foi criada: 3
                se a houve um erro: 4
                se o array ainda não está criado: 5*/
            
            //pagina a ser reencaminhada
            String nextJSP = null;
            
            switch(resultado){
                case 1:
                    System.out.println("search_serial: Reencaminha para a pagina de máquina encontrada.");
                    nextJSP = "/encontrada.jsp";
                    break;
                case 2:
                    System.out.println("search_serial: Reencaminha para a pagina de máquina não encontrada.");
                    nextJSP = "/naoEncontrada.jsp";
                    break;
                case 3:
                    System.out.println("search_serial: Reencaminha para a pagina de máquina criada.");
                    nextJSP = "/registada.jsp";
                    break;
                case 4:
                    System.out.println("search_serial: Reencaminha para a pagina de erro.");
                    nextJSP = "/erro.jsp";
                    break;
                case 5:
                    System.out.println("search_serial: Máquinas ainda não criadas!! A Criar...");
                    resultado = db.query(serial);//isto funciona, mas não volta a correr o switch...
                    break;
                default:
                    System.out.println("search_serial: Erro no case para definição da página para reencaminhamento...");
                    break;
            }
            //faz o reencaminhamento para a página definida no switch
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }catch (Exception e){
            System.out.println("search_serial: Erro: " + e);
        }finally{
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
