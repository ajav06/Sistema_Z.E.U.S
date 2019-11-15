/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global decanatoSeleccionado, Swal */

var eliminarEquipoDepartamento = null;
var equipoDepartamentoSeleccionado = null;
var estadoEsquipoSeleccionado = null;
var departamentoSeleccionado = null;
var codigoEstado = null;
var codigoEquipo = null;
var codigoDpto = null;

function  listaEquiposDepartamento(){
    $.ajax({
        url: '/sistema_zeus/webservice/equiposDpto/',
        type: 'GET',
        dataType: 'JSON',
        success: function (data, textStatus, jqXHR) {
            return data;
        }
    });
}

function buscarEquipo(){
    var id = $('select[name=nombreEquipoDI] option:selected').val();
    if (id != null){
        id=parseInt(id)+1;
    }
    
    console.log(id);
    if(id != null){
        $.ajax({
            url: '/sistema_zeus/webservice/equipos/' + id,
            type: 'GET',
            dataType: 'JSON',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                equipoDepartamentoSeleccionado = data;
            }
        });
    }
}

function buscarSelectEquipo(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('nombreEquipoD')[0];
 
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


function buscarEstadoEquipo(tipo){
    if(tipo==1){
        var id = $('select[name=estadoEquipoDI] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }else{
        var id = $('select[name=estadoEquipoDM] option:selected').val();
        if (id != null){
            id=parseInt(id)+1;
        }
    }
    
    console.log(id);
    if(id != null){
        $.ajax({
            url: '/sistema_zeus/webservice/estadosEquipo/' + id,
            type: 'GET',
            dataType: 'JSON',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                estadoEquipoSeleccionado = data;
            }
        });
    }
}

function buscarSelectEstadoEquipo(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('estadoEquipoDM')[0];
 
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


function buscarDepartamento(){
    var id = $('select[name=nombreDptoDI] option:selected').val();
    if (id != null){
        id=parseInt(id)+1;
    }
    
    console.log(id);
    if(id != null){
        $.ajax({
            url: '/sistema_zeus/webservice/departamentos/' + id,
            type: 'GET',
            dataType: 'JSON',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                departamentoSeleccionado = data;
            }
        });
    }
}

function buscarSelectDepartamento(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('nombreDptoEquipoD')[0];
 
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




function incluirEquipoDpto(){
    $.ajax({
        type: 'POST',
        url: '/sistema_zeus/webservice/equiposDpto/',
        data: JSON.stringify({
            "codigo":null,
            "codigoEquipo" : {
                "codigo" : equipoDepartamentoSeleccionado.codigo,
            },
            "codigoEstadoEquipo" : {
                "codigo" : estadoEquipoSeleccionado.codigo,
            },
            "codigoDepartamento" : {
                "codigo" : departamentoSeleccionado.codigo,
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

function actualizarEquipoDpto(){
    var id = $('input[id=codigoEM]').val();
    
    $.ajax({
        url: '/sistema_zeus/webservice/equiposDpto/' + id,
        type: 'PUT',
        data: JSON.stringify({
            "codigo": id,
            "codigoEquipo" : {
                "codigo" : codigoEquipo,
            },
            "codigoEstadoEquipo" : {
                "codigo" : estadoEquipoSeleccionado.codigo,
            },
            "codigoDepartamento" : {
                "codigo" : codigoDpto,
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

function eliminarEquipoDpto(){
    var id = eliminarEquipoDepartamento.codigo;
        
    $.ajax({
        url: '/sistema_zeus/webservice/equiposDpto/' + id,
        type: 'DELETE',
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

function consultarEquipoDpto(id, estado, equipo, codEs, codEq){
    $.ajax({
        url: '/sistema_zeus/webservice/equiposDpto/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposEquipoDepartamento(data, estado, equipo, codEs, codEq);
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

function llenarCamposEquipoDepartamento(data, estado, equipo, codEs, codEq){
    eliminarEquipoDepartamento = data;
    
    codigoDpto = data.codigoDepartamento.codigo;
    
    codigoEquipo = codEq;
    
    codigoEstado = codEs;
    
    document.getElementsByName('codigoEquipoD')[0].value = data.codigo;
    document.getElementsByName('codigoEM')[0].value = data.codigo;
    
    document.getElementsByName('estadoEquipoD')[0].value = estado;
    
    document.getElementsByName('nombreEquipoD')[0].value = equipo;
    
    document.getElementsByName('nombreDcoEquipoD')[0].value = data.codigoDepartamento.codigoDecanato.nombre;
    
    document.getElementsByName('nombreDptoEquipoD')[0].value = data.codigoDepartamento.nombre;
    
    //buscarSelectEquipo(data.codigoEquipo.nombre);
    buscarSelectEstadoEquipo(estado);
    //buscarSelectDepartamento(data.codigoDepartamento.nombre);
    
    consultar();
}
