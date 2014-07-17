/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package photoLost;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Ricardo
 */
public class db {
    private static ArrayList<Camara> camaras = null;
    
    private static Connection connect(){                                        //cria a connecção à base de dados
        try{
            /*leitura das credenciais no ficheiro
            Properties prop = new Properties();
            InputStream input = null;
            File file = new File("../../../home/pi/photolost/db");

            input = new FileInputStream(file);
            prop.load(input);*/

            String user = "root";//prop.getProperty("dbuser");
            String pass = "adminlabredes13";//prop.getProperty("dbpassword");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.228.242:3306/photolost", user, pass);

            //log
            System.out.println("db: Ligação à base de dados criada.");

            return con;
        }catch (Exception e){
            //log
            System.out.println("db: Erro na ligação à base de dados: " + e);
            return null;
        }
    }
    
    public static Integer query(Object camara){                                 //recebe algo a pesquisar (no array e não na DB)
        //verifica se o array com as camaras já existe
        if(camaras==null){
            inicia();                                                           //se não existe, cria-o e popula-o com os dados
            return 5;
        }else{
           //valida o objecto camara (que pode ser uma camara ou uma String - correspondente ao serial a pesquisar)
            try{
                //se o objecto for uma string é pk vamos fazer uma procura no array de máquinas
                if(camara instanceof String){
                    
                    for(Camara cam : camaras){
                        if(cam.getSerial().equals(camara)){
                            //log
                            System.out.println("db: Câmara " + camara + " registada na base de dados...");
                            return 1;
                        }
                    }
                    //log
                    System.out.println("db: Câmara " + camara + " não registada na base de dados...");
                    return 2;
                }else if(camara instanceof ArrayList){                          //se o objecto for um array vamos fazer um insert
                    camaras.add(novaCamara((ArrayList)camara));
                    return 3;
                }else{
                    System.out.println("db: Erro: Objecto inválido no argumento do método query.");
                    return 4;
                }
            }catch(Exception e){
                System.out.println("db: Erro na query: " + e);
                return 4;
            }finally{

            } 
        }
    }
    
    public static void inicia(){                                                //cria os objectos existentes nas base de dados
        camaras = new ArrayList<Camara>();
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        
        Connection con = connect();
        try{
            //cria as máquinas que estão registadas da DB
            String query = "SELECT * FROM photolost.camara;";
            
            Statement comando = con.createStatement();
            ResultSet res = comando.executeQuery(query);
            
            while(res.next()){
                Camara a = new Camara();
                //a.marca = res.getInt(marca);
                a.setModelo(res.getInt(2));
                a.setMail(res.getString(4));
                a.setNome(res.getString(1));
                a.setPasta(res.getString(5));
                a.setSerial(res.getString(3));
                a.setRecompensa(res.getInt(6));
                
                camaras.add(a);
                
                //debug
                //System.out.println("Camara criada id=" + a.getNome());
            }
            
            //cria as marcas que estão registadas na base de dados
            query = "SELECT * FROM photolost.marca;";
            res = comando.executeQuery(query);
            
            //debug
            //System.out.println("query ás marcas feita.");
            
            while (res.next()){
                Marca m = new Marca();
                m.setId(res.getInt(1));
                m.setNome(res.getString(2));
                
                marcas.add(m);
                
                //debug
                //System.out.println("Marca " + m.getNome() + " criada!");
            }
            
            //cria os modelos que estão registados na base de dados
            query = "SELECT * FROM photolost.modelo;";
            res = comando.executeQuery(query);
            
            //debug
            //System.out.println("query aos modelos feita.");
            
            while (res.next()){
                Modelo m = new Modelo();
                m.setId(res.getInt(1));
                m.setIdMarca(res.getInt(3));
                m.setNome(res.getString(2));
                
                modelos.add(m);
                
                //debug
                //System.out.println("Modelo " + m.getNome() + " criado!");
            }
            
        }catch (Exception e){
            System.out.println("db: Erro na criação dos objectos: " + e);
        }
    }
    
    public static Camara novaCamara(ArrayList<String> cam){
        try{
            //verifica se a marca já existe
            for(Camara camara : camaras){
                //se a camara não existe
                if(!camara.getSerial().equals(cam.get(2))){
                    //log
                    System.out.println("db: Camara " + cam.get(0) + " não existe na base de dados, será adicionada.");
                    System.out.println("db: Camara " + cam.get(1) + " não existe na base de dados, será adicionada.");
                    System.out.println("db: Camara " + cam.get(2) + " não existe na base de dados, será adicionada.");
                }else{
                    //log
                    System.out.println("db: Erro: Camara " + camara + " já está registada na base de dados!!");
                }
            }
            
            //se a marca existe, verifica se o modelo já existe
            
            //insere a nova camara na base de dados
            return null;
        }catch(Exception e){
            System.out.println("db: Erro na criação de uma nova camara: " + e);
            return null;
        }
        //insere a camara (em argumento) na base de dados
        
    }
}