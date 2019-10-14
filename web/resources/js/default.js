/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Funciones del consultar 
//Abrir el modal de consultar
function consultar(){
   $('#formconsultar').modal('show');
}

//Funciones del Modificar
//Abrir el modal de modificar y cerrar el de consultar
function modificar(id){
    $.ajax({
        url: "/sistema_zeus/webservice/equipos/"+id,
        type: "GET",
        dataType: 'XML',
        success: function (data) {
            equipo = data.getElementsByTagName('equipo');
            console.log(equipo);         
        }
    })
    
    $('#formconsultar').modal('hide');
    $('#formodificar').modal('show');
}

function aceptarModificacion(){
    $('#modificacion').modal('show');
}

//Volver al modal de consultar
function atras() {
    $('#formconsultar').modal('show');
}

//Funciones del Incluir
//Abrir el modal de incluir
function incluir() {
    $('#formincluir').modal('show');
}

function aceptarInclusion(){
    $('#inclusion').modal('show');
}

//Funciones del Eliminar
//Abrir el modal de Eliminar
function eliminar(){
    $('#txteliminar').modal('show');
}

//Cerrar el modal de Eliminar y redirigirse al modal de consultar
function cancelar(modal){
    console.log(modal);
    $('#'+modal).modal('hide');
}

//Modal para solicitar desincorporar
function desincorporar() {
    $('#formdesincorporar').modal('show');
}

//aceptar desincorporacion
function aceptarDesincorporacion(){
    $('#formdesincorporar').modal('hide');
    $('#txtdesincorporar').modal('show');
}

//Modal para solicitar reparar
function reparar(){
    $('#formreparar').modal('show');
}

//aceptar reparacion
function aceptarReparacion(){
    $('#formreparar').modal('hide');
    $('#txtreparar').modal('show');
}

function imprimir(dato) {
    console.log(dato);
}

