/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var decanatoEliminar = null;

function consultarDecanato(id){
    $.ajax({
        url: '/sistema_zeus/webservice/decanatos/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposDecanato(data);
        },
        error: function (xhr, ajaxOptions, thrownError) {
           /*alert(xhr.status);
           alert(xhr.responseText);
           alert(thrownError);*/
           alert('No se ha podido obtener la información');
       }
    });
}

function incluirDecanato(){
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/decanatos/',
        data: JSON.stringify({
            "codigo" : null,
            "nombre": $('input[id=nombreDI]').val(),
            "direccion" : $('textArea[id=direccionDI]').val(),
            "siglas" : $('input[id=siglasDI]').val(),
            "correo" : $('input[id=emailDI]').val(),
            "telefono": $('input[id=telefonoDI]').val(),
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
            Swal.fire("Error","Hubo un error realizando la inclusión","error");
        }
    });
}

function actualizarDecanato(){
    var id = $('input[id=codigoD]').val();
    console.log(id);
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/decanatos/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": $('input[id=nombreD]').val(),
            "direccion" : $('textArea[id=direccionD]').val(),
            "siglas" : $('input[id=siglasD]').val(),
            "correo" : $('input[id=emailD]').val(),
            "telefono": $('input[id=telefonoD]').val(),
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
        error: function() {
            console.log("No se ha podido obtener la información");
            alert('No se ha podido obtener la información');
        }
    });
}

function eliminarDecanto(){
    var id = decanatoEliminar.codigo;
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/decanatos/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": decanatoEliminar.nombre,
            "direccion" : decanatoEliminar.direccion,
            "siglas" : decanatoEliminar.siglas,
            "correo" : decanatoEliminar.correo,
            "telefono": decanatoEliminar.telefono,
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
        error: function() {
            console.log("No se ha podido obtener la información");
            alert('No se ha podido obtener la información');
        }
    });
}

function llenarCamposDecanato(data){
    decanatoEliminar = data;
    
    document.getElementById("codigoD").value = data.codigo;
    
    document.getElementsByName('nombreD')[0].value = data.nombre;
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

