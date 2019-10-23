/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var edoEquiEliminar = null;

function consultarEdoEqui(id){
    $.ajax({
        url: '/sistema_zeus/webservice/estadosEquipo/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {
            console.log(data);
            llenarCamposEdoEqui(data);
        }
    });
}

function incluirEdoEqui(){
    
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/estadosEquipo/',
        data: JSON.stringify({
            "codigo" : null,
            "nombre" : $('input[id=nombreEdoI]').val(),
            "descripcion": $('textArea[id=descripcionEdoI]').val(),
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

function actualizarEdoEqui(){
    var id = $('input[id=codigoEdo]').val();
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/estadosEquipo/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre" : $('input[id=nombreEdo]').val(),
            "descripcion": $('textArea[id=descripcionEdo]').val(),
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
            alert(xhr.status);
           alert(xhr.responseText);
           alert(thrownError);
        }
    });
}

function eliminarEdoEqui(){
    var id = edoEquiEliminar.codigo;
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/estadosEquipo/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": edoEquiEliminar.nombre,
            "descripcion": edoEquiEliminar.descripcion,
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

function llenarCamposEdoEqui(data){
    edoEquiEliminar = data;
    
    document.getElementsByName('nombreEdo')[0].value = data.nombre;
    document.getElementsByName('nombreEdo')[1].value = data.nombre;

    document.getElementsByName('descripcionEdo')[0].value = data.descripcion;
    document.getElementsByName('descripcionEdo')[1].value = data.descripcion;

    document.getElementById("codigoEdo").value = data.codigo;
    
    consultar();
}