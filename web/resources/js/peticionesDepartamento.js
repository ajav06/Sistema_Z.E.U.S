/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var dcaSeleccionado = null;
var dptoEliminar = null;

function buscarDca(tipo){
    if (tipo==1){
        var id = $('select[name=nombreDco] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
        
    } else if (tipo==2) {
        var id = $('input[id=codigoDca]').val();
        
    } else if (tipo==3) {
        var id = $('input[id=codigoDcaI]').val();
        
    } else if (tipo==4) {
        var id = $('select[name=nombreDcoI] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }
    
    console.log(id);
    if(id != null){
        $.ajax({
            url: '/sistema_zeus/webservice/decanatos/' + id,
            type: 'GET',
            dataType: 'JSON',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                dcaSeleccionado = data;
            }
        });
    }
}

function buscarSelectDca(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('nombreDco')[1];
 
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

function incluirDpto(){
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/departamentos/',
        data: JSON.stringify({
            "codigo": null,
            "nombre": $('input[id=nombreDptoI]').val(),
            "descripcion": $('textArea[id=descripcionDI]').val(),
            "estatus": "a",
            "codigoDecanato" : {
                "codigo": dcaSeleccionado.codigo,
                "correo": dcaSeleccionado.correo,
                "direccion": dcaSeleccionado.direccion,
                "estatus": dcaSeleccionado.estatus,
                "nombre": dcaSeleccionado.nombre,
                "siglas": dcaSeleccionado.siglas,
                "telefono": dcaSeleccionado.telefono
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

function actualizarDpto(){
    var id = $('input[id=codigoDpto]').val();
    
    $.ajax({
        url: '/sistema_zeus/webservice/departamentos/' + id,
        type: 'PUT',
        data: JSON.stringify({
            "codigo": id,
            "nombre": $('input[id=nombreDpto]').val(),
            "descripcion": $('textArea[id=descripcionD]').val(),
            "estatus": "a",
            "codigoDecanato" : {
                "codigo": dcaSeleccionado.codigo,
                "correo": dcaSeleccionado.correo,
                "direccion": dcaSeleccionado.direccion,
                "estatus": dcaSeleccionado.estatus,
                "nombre": dcaSeleccionado.nombre,
                "siglas": dcaSeleccionado.siglas,
                "telefono": dcaSeleccionado.telefono
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

function eliminarDpto(){
    var id = dptoEliminar.codigo;
        
    $.ajax({
        url: '/sistema_zeus/webservice/departamentos/' + id,
        type: 'PUT',
        data: JSON.stringify({
            "codigo": id,
            "nombre": dptoEliminar.nombre,
            "descripcion": dptoEliminar.descripcion,
            "estatus": "i",
            "codigoDecanato" : {
                "codigo": dptoEliminar.codigoDecanato.codigo,
                "correo": dptoEliminar.codigoDecanato.correo,
                "direccion": dptoEliminar.codigoDecanato.direccion,
                "estatus": dptoEliminar.codigoDecanato.estatus,
                "nombre": dptoEliminar.codigoDecanato.nombre,
                "siglas": dptoEliminar.codigoDecanato.siglas,
                "telefono": dptoEliminar.codigoDecanato.telefono
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

function consultarDpto(id){
    $.ajax({
        url: '/sistema_zeus/webservice/departamentos/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposDpto(data);
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

function llenarCamposDpto(data){
    dptoEliminar = data;
    
    document.getElementById('codigoDpto').value = data.codigo;
    
    document.getElementsByName('nombreDco')[0].value = data.codigoDecanato.nombre;
    document.getElementsByName('nombreDco')[1].value = data.codigoDecanato.nombre;
    
    document.getElementsByName('nombreDpto')[0].value = data.nombre;
    document.getElementsByName('nombreDpto')[1].value = data.nombre;
    
    document.getElementsByName('descripcionD')[0].value = data.descripcion;
    document.getElementsByName('descripcionD')[1].value = data.descripcion;
    
    buscarSelectDca(data.codigoDecanato.nombre);
    
    consultar();
}