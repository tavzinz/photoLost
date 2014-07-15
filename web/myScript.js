/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*$(document).ready(function(){
    $('#search').click(function(){
        $.get('search_serial', function(){
            $('#resposta').text(resultado);
        });
    });
});*/

function valida(){
    var marca = document.getElementById("marca").value;
    var modelo = document.getElementById("modelo").value;
    var serial = document.getElementById("serial").value;
    var mail = document.getElementById("mail").value;
    var pasta = document.getElementById("pasta").value;
    
    console.log(marca);
        
    if (marca == ""){
        document.getElementById("marca").style.backgroundColor="red";
        return false;
    }else if (modelo== ""){
        document.getElementById("marca").style.backgroundColor="white";
        document.getElementById("modelo").style.backgroundColor="red";
        return false;
    }else if (serial== ""){
        document.getElementById("serial").style.backgroundColor="red";
        return false;
    }else if (mail== ""){
        document.getElementById("mail").style.backgroundColor="red";
        return false;
    }else if (pasta== ""){
        document.getElementById("pasta").style.backgroundColor="red";
        return false;
    }else{
        return true;
    }
}