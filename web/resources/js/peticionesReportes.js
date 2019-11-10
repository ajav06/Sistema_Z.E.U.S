/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function llenarTotalesUniv(){
    $('#totaluni').toggle('slow'); 
    $.ajax({
        url: '/sistema_zeus/webservice/reportes/totales/universidad',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data.activos)
            document.getElementById('eqActUniv').innerHTML = data.activos;
            document.getElementById('eqRepUniv').innerHTML = data.reparados;
            document.getElementById('eqDesUniv').innerHTML = data.desincorporados;
            document.getElementById('eqTotUniv').innerHTML = data.totales;
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });
}

function llenarConsultaDecanato(){
    ocultarTodo();
    $('#totaldecanato').toggle('slow');
    $.ajax({
        url: '/sistema_zeus/webservice/decanatos',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            data.forEach( function(decanato, indice, array){
                $("#dropdownReporteDecanato").append(new Option(decanato.nombre,decanato.codigo))
                }
            );
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });
}

function llenarTotalesDecanato(){
    if ($("#dropdownReporteDecanato").val()!='-'){
        $.ajax({
            url: '/sistema_zeus/webservice/reportes/totales/decanato/' + $("#dropdownReporteDecanato").val() + '/',
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {            
                console.log(data.activos)
                document.getElementById('eqActUniv').innerHTML = data.activos;
                document.getElementById('eqRepUniv').innerHTML = data.reparados;
                document.getElementById('eqDesUniv').innerHTML = data.desincorporados;
                document.getElementById('eqTotUniv').innerHTML = data.totales;
            },
            error: function(xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log(thrownError);
                console.log("No se ha podido obtener la información");
                Swal.fire("Error","Hubo un error consultando los datos","error");
            }
        });
    }
}