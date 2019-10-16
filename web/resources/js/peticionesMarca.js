/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function consultarMarca(id, tip){
    $.ajax({
        url: '/sistema_zeus/webservice/marcas/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {
            
            console.log(data);
            
            if(tip == 1){
                document.getElementById('codigoM').value = data.codigo;
                document.getElementById('nombreM').value = data.nombre;
            } else {
                document.getElementById('codigoME').value = data.codigo;
                document.getElementById('nombreME').value = data.nombre;
            }
        }
    });
}

function actualizarMarca(){
    var id = $('input[id=codigoM]').val();
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/marcas/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": $('input[id=nombreM]').val(),
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

function eliminarMarca(){
    var id = $('input[id=codigoME]').val();
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/marcas/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": $('input[id=nombreME]').val(),
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

function incluirMarca(){
    
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/marcas/',
        data: JSON.stringify({
            "codigo" : null,
            "nombre": $('input[id=nombreMI]').val(),
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

