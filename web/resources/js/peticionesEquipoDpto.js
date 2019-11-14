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

function buscarEquipo(tipo){
    if(tipo==1)
    {
        var nom = $('select[id=nombreEquipoDI] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/equipos/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    equipoDepartamentoSeleccionado = data;
                }
            });
        } else {
            equipoDepartamentoSeleccionado = null;
        }
    }
    else{
        var nom = $('select[id=nombreEquipoDM] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/equipos/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    equipoDepartamentoSeleccionado = data;
                }
            });
        }
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
    if(tipo==1)
    {
        var nom = $('select[id=estadoEquipoDI] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/estadosEquipo/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    estadoEquipoSeleccionado = data;
                }
            });
        } else {
            estadoEquipoSeleccionado = null;
        }
    }
    else{
        var nom = $('select[name=estadoEquipoDM] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/estadosEquipo/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    estadoEquipoSeleccionado = data;
                }
            });
        }
    }
}

function buscarSelectEstadoEquipo(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('estadoEquipoD')[0];
 
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


function buscarDepartamento(tipo){
    if(tipo==1)
    {
        var nom = $('select[id=nombreDptoDI] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/departamentos/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    departamentoSeleccionado = data;
                }
            });
        } else {
            departamentoSeleccionado = null;
        }
    }
    else{
        var nom = $('select[name=nombreDptoDM] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/departamentos/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    departamentoSeleccionado = data;
                }
            });
        }
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
            "codigoEquipo" : {
                "codigo" : equipoDepartamentoSeleccionado.codigo,
                "codigoMarca" : equipoDepartamentoSeleccionado.codigoMarca,
                "nombre" : equipoDepartamentoSeleccionado.nombre,
                "descripcion" : equipoDepartamentoSeleccionado.descripcion,
                "estatus" : equipoDepartamentoSeleccionado.estatus
            },
            "codigoEstadoEquipo" : {
                "codigo" : estadoEquipoSeleccionado.codigo,
                "nombre" : estadoEquipoSeleccionado.nombre,
                "descripcion" : estadoEquipoSeleccionado.descripcion,
                "estatus" : estadoEquipoSeleccionado.estatus
            },
            "codigoDepartamento" : {
                "codigo" : departamentoSeleccionado.codigo,
                "codigoDecanato" : departamentoSeleccionado.codigoDecanato,
                "nombre" : departamentoSeleccionado.nombre,
                "descripcion" : departamentoSeleccionado.descripcion,
                "estatus" : departamentoSeleccionado.estatus
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
    var id = $('input[id=codigo]').val();
    
    $.ajax({
        url: '/sistema_zeus/webservice/equiposDpto/' + id,
        type: 'PUT',
        data: JSON.stringify({
            "codigoEquipo" : {
                "codigo" : equipoDepartamentoSeleccionado.codigo,
                "codigoMarca" : equipoDepartamentoSeleccionado.codigoMarca,
                "nombre" : equipoDepartamentoSeleccionado.nombre,
                "descripcion" : equipoDepartamentoSeleccionado.descripcion,
                "estatus" : equipoDepartamentoSeleccionado.estatus
            },
            "codigoEstadoEquipo" : {
                "codigo" : estadoEquipoSeleccionado.codigo,
                "nombre" : estadoEquipoSeleccionado.nombre,
                "descripcion" : estadoEquipoSeleccionado.descripcion,
                "estatus" : estadoEquipoSeleccionado.estatus
            },
            "codigoDepartamento" : {
                "codigo" : departamentoSeleccionado.codigo,
                "codigoDecanato" : departamentoSeleccionado.codigoDecanato,
                "nombre" : departamentoSeleccionado.nombre,
                "descripcion" : departamentoSeleccionado.descripcion,
                "estatus" : departamentoSeleccionado.estatus
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
        type: 'PUT',
        data: JSON.stringify({
            "codigoEquipo" : {
                "codigo" : eliminarEquipoDepartamento.codigoEquipo.codigo,
                "codigoMarca" : eliminarEquipoDepartamento.codigoEquipo.codigoMarca,
                "nombre" : eliminarEquipoDepartamento.codigoEquipo.nombre,
                "descripcion" : eliminarEquipoDepartamento.codigoEquipo.descripcion,
                "estatus" : eliminarEquipoDepartamento.codigoEquipo.estatus
            },
            "codigoEstadoEquipo" : {
                "codigo" : eliminarEquipoDepartamento.codigoEstadoEquipo.codigo,
                "nombre" : eliminarEquipoDepartamento.codigoEstadoEquipo.nombre,
                "descripcion" : eliminarEquipoDepartamento.codigoEstadoEquipo.descripcion,
                "estatus" : eliminarEquipoDepartamento.codigoEstadoEquipo.estatus
            },
            "codigoDepartamento" : {
                "codigo" : eliminarEquipoDepartamento.codigoDepartamento.codigo,
                "codigoDecanato" : eliminarEquipoDepartamento.codigoDepartamento.codigoDecanato,
                "nombre" : eliminarEquipoDepartamento.codigoDepartamento.nombre,
                "descripcion" : eliminarEquipoDepartamento.codigoDepartamento.descripcion,
                "estatus" : eliminarEquipoDepartamento.codigoDepartamento.estatus
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

function consultarEquipoDpto(id){
    $.ajax({
        url: '/sistema_zeus/webservice/equiposDpto/' + id,
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            llenarCamposEquipoDepartamento(data);
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

function llenarCamposEquipoDepartamento(data){
    eliminarEquipoDepartamento = data;
    
    document.getElementsByName('codigoEquipoD')[0].value = data.codigo;
    document.getElementsByName('codEq')[0].value = data.codigo;
   //document.getElementsByName('estadoEquipoD')[0].value = data.codigoEstadoEquipo.nombre;
    
    //document.getElementsByName('nombreEquipoD')[0].value = data.codigoEquipo.nombre;
    
    document.getElementsByName('nombreDcoEquipoD')[0].value = data.codigoDepartamento.codigoDecanato.nombre;
    
    document.getElementsByName('nombreDptoEquipoD')[0].value = data.codigoDepartamento.nombre;
    
    //buscarSelectEquipo(data.codigoEquipo.nombre);
   // buscarSelectEstadoEquipo(data.codigoEstadoEquipo.codigo);
    buscarSelectDepartamento(data.codigoDepartamento.nombre);
    
    consultar();
}
