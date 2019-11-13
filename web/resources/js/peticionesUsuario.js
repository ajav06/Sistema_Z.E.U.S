/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var usuarioEliminar = null;
var dcnSeleccionado = null;
var dtoSeleccionado = null;

function consultarUsuario(id){
    $.ajax({
        url: '/sistema_zeus/webservice/usuarios/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposUsuario(data);
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

function incluirUsuario(){
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/usuarios/',
        data: JSON.stringify({
            "codigo" : null,
            "nombreUsuario": $('input[id=nombreU]').val(),
            "contrasenna": $('input[id=contrasenna]').val(),
            "cedula": $('input[id=cedula]').val(),
            "nombre": $('input[id=nombre]').val(),
            "apellido": $('input[id=apellido]').val(),
            "direccion" : $('textArea[id=direccionU]').val(),
            "telefono": $('input[id=telefonoU]').val(),
            "correo" : $('input[id=emailU]').val(),
            "estatus": "a",
            "codigoDecanato" : {
                "codigo": dcnSeleccionado.codigo,
                "correo": dcnSeleccionado.correo,
                "direccion": dcnSeleccionado.direccion,
                "estatus": dcnSeleccionado.estatus,
                "nombre": dcnSeleccionado.nombre,
                "siglas": dcnSeleccionado.siglas,
                "telefono": dcnSeleccionado.telefono,
            },
            "codigoDepartamento" : {
                "codigo": dtoSeleccionado.codigo,
                "nombre": dtoSeleccionado.nombre,
                "descripcion": dtoSeleccionado.descripcion
            }
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Actualizado: "+data);
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

function actualizarUsuario(){
    var id = $('input[id=codigoU]').val();
    console.log(id);
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/usuarios/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombreUsuario": $('input[id=nombreU]').val(),
            "contrasenna": $('input[id=contrasenna]').val(),
            "cedula": $('input[id=cedula]').val(),
            "nombre": $('input[id=nombre]').val(),
            "apellido": $('input[id=apellido]').val(),
            "direccion" : $('textArea[id=direccionU]').val(),
            "telefono": $('input[id=telefonoU]').val(),
            "correo" : $('input[id=emailU]').val(),
            "estatus": "a"
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Actualizado: "+data);
            $('#txtexito').modal('show');
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la modificación","error");
        }
    });
}

function eliminarUsuario(){
    var id = usuarioEliminar.codigo;
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/usuarios/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombreUsuario": usuarioEliminar.nombreUsuario,
            "contrasenna": usuarioEliminar.contrasenna,
            "cedula": usuarioEliminar.cedula,
            "nombre": usuarioEliminar.nombre,
            "apellido": usuarioEliminar.apellido,
            "direccion" : usuarioEliminar.direccion,
            "telefono": usuarioEliminar.telefono,
            "correo" : usuarioEliminar.correo,
            "estatus": "i"
        }),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (data) {
            console.log("Actualizado: "+data);
            $('#txtexito').modal('show');
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error realizando la eliminación","error");
        }
    });
}

function llenarCamposDecanato(data){
    decanatoEliminar = data;
    
    document.getElementsByName("usernameU")[0].value = data.nombreUsuario;
    
    document.getElementsName('tipoU')[0].value = data;
    document.getElementsByName('nombreD')[1].value = data.nombre;
    
    document.getElementsByName('siglasD')[0].value = data.siglas;
    document.getElementsByName('siglasD')[1].value = data.siglas;
    
    document.getElementsByName('direccionD')[0].value = data.direccion;
    document.getElementsByName('direccionD')[1].value = data.direccion;
    
    document.getElementsByName('emailD')[0].value = data.correo;
    document.getElementsByName('emailD')[1].value = data.correo;
    
    document.getElementsByName('emailD')[0].value = data.correo;
    document.getElementsByName('emailD')[1].value = data.correo;
    
    document.getElementsByName('telefonoD')[0].value = data.telefono;
    document.getElementsByName('telefonoD')[1].value = data.telefono;
    
}