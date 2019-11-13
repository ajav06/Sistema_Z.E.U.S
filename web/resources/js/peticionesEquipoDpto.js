/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global decanatoSeleccionado, Swal */

var eliminarEquipoDepartamento = null;
var equipoSeleccionado = null;
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
        var nom = $('select[id=nombreEI] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/equipos/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    equipoSeleccionado = data;
                }
            });
        } else {
            equipoSeleccionado = null;
        }
    }
    else{
        var nom = $('select[id=nombreE] option:selected').text();
        console.log(nom);
        if (nom != "Seleccione..."){
            $.ajax({
                url: '/sistema_zeus/webservice/equipos/' + nom,
                type: 'GET',
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    equipoSeleccionado = data;
                }
            });
        }
    }
}

function buscarSelectEquipo(id)
{
	// creamos un variable que hace referencia al select
	var select=document.getElementsByName('nombreE')[0];
 
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
        var nom = $('select[id=nombreEdoI] option:selected').text();
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
        var nom = $('select[name=nombreEdo] option:selected').text();
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
	var select=document.getElementsByName('nombreEdo')[0];
 
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
        var nom = $('select[id=nombreDptoI] option:selected').text();
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
        var nom = $('select[name=nombreDpto] option:selected').text();
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
	var select=document.getElementsByName('nombreDpto')[0];
 
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
                "codigo" : equipoSeleccionado.codigo,
                "nombre" : equipoSeleccionado.nombre,
                "descirpcion" : equipoSeleccionado.descripcion,
                "estatus" : equipoSeleccionado.estatus
            },
            "codigoEstadoEquipo" : {
                "codigo" : estadoEquipoSeleccionado.codigo,
                "nombre" : estadoEquipoSeleccionado.nombre,
                "descirpcion" : estadoEquipoSeleccionado.descripcion,
                "estatus" : estadoEquipoSeleccionado.estatus
            },
            "codigoDepartamento" : {
                "codigo" : decanatoSeleccionado.codigo,
                "nombre" : decanatoSeleccionado.nombre,
                "descirpcion" : decanatoSeleccionado.descripcion,
                "estatus" : decanatoSeleccionado.estatus
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
                "codigo" : equipoSeleccionado.codigo,
                "nombre" : equipoSeleccionado.nombre,
                "descirpcion" : equipoSeleccionado.descripcion,
                "estatus" : equipoSeleccionado.estatus
            },
            "codigoEstadoEquipo" : {
                "codigo" : estadoEquipoSeleccionado.codigo,
                "nombre" : estadoEquipoSeleccionado.nombre,
                "descirpcion" : estadoEquipoSeleccionado.descripcion,
                "estatus" : estadoEquipoSeleccionado.estatus
            },
            "codigoDepartamento" : {
                "codigo" : decanatoSeleccionado.codigo,
                "nombre" : decanatoSeleccionado.nombre,
                "descirpcion" : decanatoSeleccionado.descripcion,
                "estatus" : decanatoSeleccionado.estatus
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
                "nombre" : eliminarEquipoDepartamento.codigoEquipo.nombre,
                "descirpcion" : eliminarEquipoDepartamento.codigoEquipo.descripcion,
                "estatus" : eliminarEquipoDepartamento.codigoEquipo.estatus
            },
            "codigoEstadoEquipo" : {
                "codigo" : eliminarEquipoDepartamento.codigoEstadoEquipo.codigo,
                "nombre" : eliminarEquipoDepartamento.codigoEstadoEquipo.nombre,
                "descirpcion" : eliminarEquipoDepartamento.codigoEstadoEquipo.descripcion,
                "estatus" : eliminarEquipoDepartamento.codigoEstadoEquipo.estatus
            },
            "codigoDepartamento" : {
                "codigo" : eliminarEquipoDepartamento.codigoDepartamento.codigo,
                "nombre" : eliminarEquipoDepartamento.codigoDepartamento.nombre,
                "descirpcion" : eliminarEquipoDepartamento.codigoDepartamento.descripcion,
                "estatus" : eliminarEquipoDepartamento.codigoDepartamento.estatus,
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
        url: '/sistema_zeus/webservice/esquiposDpto/' + id,
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
    
    document.getElementById('codigo').value = data.codigo;
    
    document.getElementsByName('estadoE')[0].value = data.codigoEstadoEquipo.nombre;
    document.getElementsByName('estadoE')[1].value = data.codigoEstadoEquipo.nombre;
    
    document.getElementsByName('nombreE')[0].value = data.codigoEquipo.nombre;
    document.getElementsByName('nombreE')[1].value = data.codigoEquipo.nombre;
    
    document.getElementByName('nombreDco')[0].value = data.codigoDecanato.nombre;
    document.getElementByName('nombreDco')[1].value = data.codigoDecanato.nombre;
    
    document.getElementsByName('nombreDpto')[0].value = data.codigoDepartamento.nombre;
    document.getElementsByName('nombreDpto')[1].value = data.codigoDepartamento.nombre;
    
    buscarSelectEquipo(data.codigoEquipo.nombre);
    buscarSelectEstadoEquipo(data.codigoEstadoEquipo.codigo);
    buscarSelectDepartamento(data.codigoDepartamento.nombre);
    
    consultar();
}
