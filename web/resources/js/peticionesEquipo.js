/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var marcaSeleccionada = null;
var equipoEliminar = null;

function buscarMarca(tipo){
    if(tipo==1){
        var nom = $('select[name=codigoMarcaEI] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/marcas/nombre/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    marcaSeleccionada = data;
                }
            });
        }
    }else{
        var nom = $('select[name=codigoMarcaE] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/marcas/nombre/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    marcaSeleccionada = data;
                }
            });
        }
    }
    
}

function buscarSelectMarca(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('codigoMarcaE')[0];
 
	// obtenemos el valor a buscar
	var buscar=id;
 
	// recorremos todos los valores del select
	for(var i=1;i<select.length;i++)
	{
            if(select.options[i].text==buscar)
            {
                // seleccionamos el valor que coincide
                select.selectedIndex=i;
            }
	}
}

function  listaEquipos(){
    $.ajax({
        url: '/sistema_zeus/webservice/equipos/',
        type: 'GET',
        dataType: 'JSON',
        success: function (data, textStatus, jqXHR) {
            return data;
        }
    });
}

function consultarEquipo(id){
    $.ajax({
        url: '/sistema_zeus/webservice/equipos/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposEquipo(data);
        },
        error: function (xhr, ajaxOptions, thrownError) {
           /*alert(xhr.status);
           alert(xhr.responseText);
           alert(thrownError);*/
           alert('No se ha podido obtener la información');
       }
    });
}

function incluirEquipo(){
    
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/equipos/',
        data: JSON.stringify({
            "codigo" : null,
            "nombre": $('input[id=nombreEI]').val(),
            "descripcion" : $('textArea[id=descripcionEI]').val(),
            "estatus": "a",
            "codigoMarca":{
                "codigo": marcaSeleccionada.codigo,
                "nombre": marcaSeleccionada.nombre,
                "estatus": marcaSeleccionada.estatus
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
        error: function() {
            console.log("No se ha podido obtener la información");
            alert('No se ha podido obtener la información');
        }
    });
}

function actualizarEquipo(){
    var id = $('input[id=codigoE]').val();
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/equipos/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": $('input[id=nombreE]').val(),
            "descripcion" : $('textArea[id=descripcionE]').val(),
            "estatus": "a",
            "codigoMarca":{
                "codigo": marcaSeleccionada.codigo,
                "nombre": marcaSeleccionada.nombre,
                "estatus": marcaSeleccionada.estatus
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
        error: function() {
            console.log("No se ha podido obtener la información");
            alert('No se ha podido obtener la información');
        }
    });
}

function eliminarEquipo(){
    var id = equipoEliminar.codigo;
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/equipos/'+id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": equipoEliminar.nombre,
            "descripcion" : equipoEliminar.descripcion,
            "estatus": "i",
            "codigoMarca":{
                "codigo": equipoEliminar.codigoMarca.codigo,
                "nombre": equipoEliminar.codigoMarca.nombre,
                "estatus": equipoEliminar.codigoMarca.estatus
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
        error: function() {
            console.log("No se ha podido obtener la información");
            alert('No se ha podido obtener la información');
        }
    });
}

function llenarCamposEquipo(data){          
    equipoEliminar = data;

    document.getElementsByName('nombreE')[0].value = data.nombre;
    document.getElementsByName('nombreE')[1].value = data.nombre;

    document.getElementsByName('descripcionE')[0].value = data.descripcion;
    document.getElementsByName('descripcionE')[1].value = data.descripcion;

    document.getElementById("codigoE").value = data.codigo;

    document.getElementsByName('marcaE')[0].value = data.codigoMarca.nombre;

    buscarSelectMarca(data.codigoMarca.nombre);

    consultar();
}