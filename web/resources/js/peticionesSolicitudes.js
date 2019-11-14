/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var solEliminar = null;
var usuario =null;


function consultarSolicitud(id){
    $.ajax({
        url: '/sistema_zeus/webservice/solicitudes/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposSolicitudes(data);
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
    var equi= $('input[id=codEq]').val();
    buscarUsuario(nombreU);
    var fecha = new Date();
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/solicitudes/',
        data: JSON.stringify({
            "codigo" : null,
            "nombreUsuario": {
                "nombreUsuario":usuario.nombreUsuario,
                "codigoDepartamento": usuario.codigoDepartamento,
                "contrasenna": usuario.contrasenna,
                "cedula": usuario.cedula,
                "nombre": usuario.nombre,
                "apellido": usuario.apellido,
                "direccion": usuario.direccion,
                "telefono": usuario.telefono,
                "correo": usuario.correo,
                "estatus": usuario.estatus,
                
            },
            "codigoEquipoDepartamento" : equi,
            "tipoSolicitud":  "R",
            "fechaInicio" : "'"+fecha.getDate()+"-"+fecha.getMonth()+"-"+fecha.getFullYear()+"'",
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


function llenarCamposSolicitudes(data){
    solEliminar = data;
    
    document.getElementsByName('nombreEq')[0].value = data.codigoEquipoDepartamento.codigoEquipo.nombre;
    
    document.getElementsByName('fechaE')[0].value = data.fechaInicio;
    
    document.getElementsByName('estadoEq')[0].value = data.codigoEquipoDepartamento.codigoEstadoEquipo.nombre;
    
    document.getElementsByName('decanato')[0].value = data.codigoEquipoDepartamento.codigoDepartamento.codigoDecanato.nombre;
    
    document.getElementsByName('departamento')[0].value = data.codigoEquipoDepartamento.codigoDepartamento.nombre;
    
    document.getElementsByName('emisor')[0].value = data.nombreUsuario.nombre;
    
    document.getElementsByName('motivo')[0].value = data.motivo;
    
    consultar();
}





