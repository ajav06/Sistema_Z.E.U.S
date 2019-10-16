/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var marcaSeleccionada = null;

function buscarSelectMarca(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('codigoMarca')[0];
 
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
        success: function (data, textStatus, jqXHR) {
                        
            console.log(data);
            
            document.getElementsByName('nombre')[0].value = data.nombre;
            document.getElementsByName('nombre')[1].value = data.nombre;
            
            document.getElementsByName('descripcion')[0].value = data.descripcion;
            document.getElementsByName('descripcion')[1].value = data.descripcion;
            
            document.getElementById("codigo").value = data.codigo;
            
            document.getElementsByName('marca')[0].value = data.codigoMarca.nombre;
            
            buscarSelectMarca(data.codigoMarca.nombre);
            
            consultar();
        }
    });
}

function actualizarEquipo(){
    var id = $('input[id=codigo]').val();
    
    $.ajax({
        type: 'PUT',
        url: '/sistema_zeus/webservice/equipos/' + id,
        data: JSON.stringify({
            "codigo" : id,
            "nombre": $('input[id=nombre]').val(),
            "descripcion" : $('textArea[id=descripcion]').val(),
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
            location.reload();
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
}

function buscarMarca(){
    var nom = $('select[name=codigoMarca] option:selected').text();
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