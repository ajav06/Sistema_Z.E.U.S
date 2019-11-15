/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var usuarioEliminar = null;
var dcnSeleccionado = null;
var dptoSeleccionado = null;
var tipoUSeleccionado = null;

function consultarUsuario(nombre){
    $.ajax({
        url: '/sistema_zeus/webservice/usuarios/' + nombre,
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
            Swal.fire("Error","Hubo un error realizando la consulta","error");
        }
    });
}

function incluirUsuario(){
    var fecha = new Date();
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/usuarios/',
        data: JSON.stringify({
            "nombreUsuario": $('input[id=usernameUI]').val(),
            "contrasenna": 1234,
            "cedula": $('input[id=cedulaUI]').val(),
            "nombre": $('input[id=nombreUI]').val(),
            "apellido": $('input[id=apellidoUI]').val(),
            "direccion" : $('input[id=direccionUI]').val(),
            "telefono": $('input[id=telefonoUI]').val(),
            "correo" : $('input[id=emailUI]').val(),
            "estatus": "a",
            "grupoUsuario":{
                "nombreUsuario": $('input[id=usernameUI]').val(),
                "codigoTipoUsuario":{
                    "codigo": tipoUSeleccionado.codigo,
                    "nombre": tipoUSeleccionado.nombre,
                    "estatus": tipoUSeleccionado.estatus
                },
                "fechaModificacion":fecha
            },
            "codigoDepartamento" : {
                "codigo": dptoSeleccionado.codigo,
                "nombre": dptoSeleccionado.nombre,
                "descripcion": dptoSeleccionado.descripcion
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
    var id = $('input[id=usernameU]').val().toString();
    console.log(id);
    var fecha = new Date();
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/usuarios/' + id,
        data: JSON.stringify({
            "nombreUsuario": id,
            "contrasenna": 1234,
            "cedula": $('input[id=cedulaU]').val(),
            "nombre": $('input[id=nombreU]').val(),
            "apellido": $('input[id=apellidoU]').val(),
            "direccion" : $('input[id=direccionU]').val(),
            "telefono": $('input[id=telefonoU]').val(),
            "correo" : $('input[id=emailU]').val(),
            "estatus": "a",
            "grupoUsuario":{
                "nombreUsuario":id,
                "codigoTipoUsuario":{
                    "codigo": tipoUSeleccionado.codigo,
                    "nombre": tipoUSeleccionado.nombre,
                    "estatus": tipoUSeleccionado.estatus
                },
                "fechaModificacion":fecha
            },
            
            "codigoDepartamento" : {
                "codigo": dptoSeleccionado.codigo,
                "nombre": dptoSeleccionado.nombre,
                "descripcion": dptoSeleccionado.descripcion
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
            "nombreUsuario": usuarioEliminar.nombreUsuario,
            "contrasenna": usuarioEliminar.contrasenna,
            "cedula": usuarioEliminar.cedula,
            "nombre": usuarioEliminar.nombre,
            "apellido": usuarioEliminar.apellido,
            "direccion" : usuarioEliminar.direccion,
            "telefono": usuarioEliminar.telefono,
            "correo" : usuarioEliminar.correo,
            "estatus": "i",
            
            "codigoDepartamento" : {
                "codigo": dptoSeleccionado.codigo,
                "nombre": dptoSeleccionado.nombre,
                "descripcion": dptoSeleccionado.descripcion
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
            Swal.fire("Error","Hubo un error realizando la eliminación","error");
        }
    });
}

function llenarCamposUsuario(data){          
    usuarioEliminar = data;

    document.getElementsByName('usernameU')[0].value = data.nombreUsuario;
    document.getElementsByName('usernameU')[1].value = data.nombreUsuario;
    
    document.getElementsByName('tipoU')[0].value = data.grupoUsuario.codigoTipoUsuario.nombre;

    document.getElementsByName('cedulaU')[0].value = data.cedula;
    document.getElementsByName('cedulaU')[1].value = data.cedula;
    
    document.getElementsByName('nombreU')[0].value = data.nombre;
    document.getElementsByName('nombreU')[1].value = data.nombre;    
    
    document.getElementsByName('apellidoU')[0].value = data.apellido;
    document.getElementsByName('apellidoU')[1].value = data.apellido;
    
    document.getElementsByName('direccionU')[0].value = data.direccion;
    document.getElementsByName('direccionU')[1].value = data.direccion;
    
    document.getElementsByName('telefonoU')[0].value = data.telefono;
    document.getElementsByName('telefonoU')[1].value = data.telefono;
    
    document.getElementsByName('emailU')[0].value = data.correo;
    document.getElementsByName('emailU')[1].value = data.correo;
    
    
    
    consultar();
}

function buscarDptoU(tipo){
    if(tipo==1){
        var id = $('select[name=departamentoUI] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }else{
        var id = $('select[name=departamentoU] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }
    
    console.log(id);
    if(id != null){
        $.ajax({
            url: '/sistema_zeus/webservice/departamentos/' + id,
            type: 'GET',
            dataType: 'JSON',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                dptoSeleccionado = data;
            }
        });
    }
}

function buscarTipoU(tipo){
    if(tipo==1){
        var id = $('select[name=tipoUI] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }else{
        var id = $('select[name=tipoU] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }
    
    console.log(id);
    if(id != null){
        $.ajax({
            url: '/sistema_zeus/webservice/tipoUsuarios/' + id,
            type: 'GET',
            dataType: 'JSON',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                tipoUSeleccionado = data;
            }
        });
    }
}