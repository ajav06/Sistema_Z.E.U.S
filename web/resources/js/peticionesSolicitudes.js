/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var solEliminar = null;
var usuario =null;


function consultarSolicitud(id, equ, est, fech, emi){
    $.ajax({
        url: '/sistema_zeus/webservice/solicitudes/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposSolicitudes(data, equ, est, fech, emi);
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la inclusión","error");
        }
    });
}
/*function consultarSolicitud(id){
    $.ajax({
        url: '/sistema_zeus/webservice/solicitudes/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposSolicitud(data);
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la consulta","error");
        }
    });
}*/
function buscarUsuario(id){
    $.ajax({
        url: '/sistema_zeus/webservice/usuarios/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            usurio=data;
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la inclusión","error");
        }
    });
}

function incluirSolicitudReparacion(nombreU){
    var equi = equi = $('input[id=codigoEqR]').val();
    console.log(equi);
    var fecha = new Date();
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/solicitudes/',
        data: JSON.stringify({
            "codigo" : null,
            "nombreUsuario": {
                "nombreUsuario":nombreU,
            },
            "codigoEquipoDepartamento" : {
                "codigo":equi,
            },
            "tipoSolicitud":  "R",
            "fechaInicio" : fecha,
            "motivo": $('textArea[id=motivoR]').val(),
            "estatus": "P"
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Registrado: "+data);
            $('#txtexito').modal('show');
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la inclusión","error");
        }
    });
}

function incluirSolicitudDesincorporacion(nombreU){
    var equi = equi = $('input[id=codigoEqD]').val();
    console.log(equi);
    var fecha = new Date();
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/solicitudes/',
        data: JSON.stringify({
            "codigo" : null,
            "nombreUsuario": {
                "nombreUsuario":nombreU,
            },
            "codigoEquipoDepartamento" : {
                "codigo":equi,
            },
            "tipoSolicitud":  "D",
            "fechaInicio" : fecha,
            "motivo": $('textArea[id=motivoD]').val(),
            "estatus": "P"
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Registrado: "+data);
            $('#txtexito').modal('show');
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la inclusión","error");
        }
    });
}

function aceptarSolicitud(id){
    var fecha = new Date();
    $.ajax({
        url: '/sistema_zeus/webservice/solicitudes/' + id,
        type: 'PUT',
        data: JSON.stringify({
            "FechaA": "'"+fecha.getDay()+"-"+fecha.getMonth()+"-"+fecha.getFullYear()+"'",
            "estatus": "E"
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Aceptado: "+data);
            $('#txtexito').modal('show');
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando al aceptar la solicitud","error");
        }
    });
}
function rechazarSolicitud(id){
    var fecha = new Date();
    $.ajax({
        url: '/sistema_zeus/webservice/solicitudes/' + id,
        type: 'PUT',
        data: JSON.stringify({
            "FechaA": "'"+fecha.getDay()+"-"+fecha.getMonth()+"-"+fecha.getFullYear()+"'",
            "estatus": "F"
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Rechazado: "+data);
            $('#txtexito').modal('show');
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando al rechazar la solicitud","error");
        }
    });
}


function llenarCamposSolicitudes(data, equ, est, fech, emi){
    solEliminar = data;
    
    document.getElementsByName('nombreEq')[0].value = equ;
    
    document.getElementsByName('fechaE')[0].value = fech;
    
    document.getElementsByName('estadoEq')[0].value = est;
    
    document.getElementsByName('decanato')[0].value = data.codigoEquipoDepartamento.codigoDepartamento.codigoDecanato.nombre;
    
    document.getElementsByName('departamento')[0].value = data.codigoEquipoDepartamento.codigoDepartamento.nombre;
    
    document.getElementsByName('emisor')[0].value = emi;
    
    document.getElementsByName('motivo')[0].value = data.motivo;
    
    consultar();
}





