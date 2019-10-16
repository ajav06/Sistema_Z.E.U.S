/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var equipoSeleccionado;

$(document).ready(function() {
    $('#listas').DataTable({
        "ordering": false,
        "pagingType": "simple_numbers",
        "pageLength": 4,
        "language": {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     '<i class="right chevron icon"></i>',
                "sPrevious": '<i class="left chevron icon"></i>'
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });
} );


// Funciones del consultar 
//Abrir el modal de consultar
function consultar(){
   $('#formconsultar').modal('show');
}

//Funciones del Modificar
//Abrir el modal de modificar y cerrar el de consultar
function modificar(){
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

function recargarPagina(){
    location.reload();
}

/*
function mostrarEquipo(id){
    //esta será nuestra petición
    var url="/sistema_zeus/webservice/equipos/"+id;
    //obtenemos el objeto para manejar peticiones en XML...
    if (window.XMLHttpRequest)  req = new XMLHttpRequest();
    //.. tambien puede estar como ActiveX
    else if (window.ActiveXObject)  req = new ActiveXObject("Microsoft.XMLHTTP");
    //asociamos un metodo alevento que se ejecuta a medida que vaya leyendo el XML
    req.onreadystatechange = processRequestEquipo;
    //pedimos el xml
    req.open("GET", url, true);
    //no enviamos nada y termina
    req.send(null);
    
}
function processRequestEquipo(){ //este metodo se ejecuta a medida que va cargando el XML.
/** los estados pueden ser
  0: no se ha iniciado
  1: esta cargando
  2: ya ha cargado
  3: esta intercambiando con el cliente
  4: ha terminado
*//*
    if (req.readyState==4){
        /*y cuando haya terminado procesa el mensaje
         (200: el requerimiento ha sido satisfactorio)*//*
        if (req.status==200) llenarDatosEquipo();
        //sino, hubo un problema al obtener el XML
        else alert("no se pudo obtener los datos de la marca");
    }
}
function llenarDatosEquipo(){
    //obtenemos el XML
    var response=req.responseXML.documentElement;
    equipoSeleccionado = response;
    
    //obtenemos de nuestro HTML la zona donde escribiremos el resultado
    // var cboProducto=document.getElementById("producto");
    // cboProducto.disabled=false;
    var equipos = response.getElementsByTagName("nombre");
    var equi = equipos[0].firstChild.data;
    
    document.getElementsByName('nombre')[0].value = equi;
    document.getElementsByName('nombre')[1].value = equi;
    
    equipos = response.getElementsByTagName("descripcion");
    equi = equipos[0].firstChild.data;
    
    document.getElementsByName('descripcion')[0].value = equi;
    document.getElementsByName('descripcion')[1].value = equi;
    
    equipos = response.getElementsByTagName("codigo");
    equi = equipos[0].firstChild.data;
    console.log(equi);
    
    document.getElementById("codigo").value = equi;
    
    var marcas = response.getElementsByTagName("codigoMarca");
    var marca = marcas[0];
    var nombres = marca.getElementsByTagName("nombre");
    var nombre = nombres[0].firstChild.data;
    
    document.getElementsByName('marca')[0].value = nombre;
    
    buscarSelectMarca(nombre);
    
    $('#formconsultar').modal('show');
}

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
*/
