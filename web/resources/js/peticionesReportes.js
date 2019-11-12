/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//MOSTRAR INTERFACES DE CONSULTA

function mostrarConsultaDecanato(){
    ocultarTodo();
    $('#totaldecanato').toggle('slow');
    $("#dropdownReporteDecanato").empty();
    $("#dropdownReporteDecanato").append(new Option("...","-"));
    $.ajax({
        url: '/sistema_zeus/webservice/decanatos',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            data.forEach( function(decanato, indice, array){
                $("#dropdownReporteDecanato").append(new Option(decanato.nombre,decanato.codigo))
                }
            );
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });
}

function mostrarConsultaDepartamento(){
    ocultarTodo();
    $('#totaldep').toggle('slow');
    $("#dropdownDecanatoReporteDpto").empty();
    $("#dropdownDecanatoReporteDpto").append(new Option("...","-"));
    $.ajax({
        url: '/sistema_zeus/webservice/decanatos',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            data.forEach( function(decanato, indice, array){
                $("#dropdownDecanatoReporteDpto").append(new Option(decanato.nombre,decanato.codigo))
                }
            );
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });        
}

function mostrarConsultaMayorMenorDecanato(){
    ocultarTodo();
    $('#maydecanato').toggle('slow');
    $("#dropdownMayorMenorPorDecanato").empty();
    $("#dropdownMayorMenorPorDecanato").append(new Option("...","-"));
    $.ajax({
        url: '/sistema_zeus/webservice/decanatos',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data);
            data.forEach( function(decanato, indice, array){
                $("#dropdownMayorMenorPorDecanato").append(new Option(decanato.nombre,decanato.codigo))
                }
            );
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });
}

function cargarDepartamentos(){
    $("#dropdownDepartamentoReporteDpto").empty();
    $("#dropdownDepartamentoReporteDpto").append(new Option("...","-"));
    document.getElementById('eqActDpt').innerHTML = "";
    document.getElementById('eqRepDpt').innerHTML = "";
    document.getElementById('eqDesDpt').innerHTML = "";
    document.getElementById('eqTotDpt').innerHTML = "";
    if ($("#dropdownDecanatoReporteDpto").val() != "-"){
        $("#dropdownDepartamentoReporteDpto").empty();
        $("#dropdownDepartamentoReporteDpto").append(new Option("...","-"));
        $.ajax({
            url: '/sistema_zeus/webservice/departamentos/decanato/' + $("#dropdownDecanatoReporteDpto").val() + '/',
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {            
                console.log(data);
                data.forEach( function(departamento, indice, array){
                    $("#dropdownDepartamentoReporteDpto").append(new Option(departamento.nombre,departamento.codigo))
                    }
                );
            },
            error: function(xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log(thrownError);
                console.log("No se ha podido obtener la información");
                Swal.fire("Error","Hubo un error consultando los datos","error");
            }
        });
    }
}

//LLENAR REPORTES DE TOTALES

function llenarTotalesUniv(){
    $('#totaluni').toggle('slow'); 
    $.ajax({
        url: '/sistema_zeus/webservice/reportes/totales/universidad',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            console.log(data.activos)
            document.getElementById('eqActUniv').innerHTML = data.activos;
            document.getElementById('eqRepUniv').innerHTML = data.reparados;
            document.getElementById('eqDesUniv').innerHTML = data.desincorporados;
            document.getElementById('eqTotUniv').innerHTML = data.totales;
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });
}

function llenarTotalesDecanato(){
    if ($("#dropdownReporteDecanato").val()!='-'){
        $.ajax({
            url: '/sistema_zeus/webservice/reportes/totales/decanato/' + $("#dropdownReporteDecanato").val() + '/',
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {            
                document.getElementById('eqActDec').innerHTML = data.activos;
                document.getElementById('eqRepDec').innerHTML = data.reparados;
                document.getElementById('eqDesDec').innerHTML = data.desincorporados;
                document.getElementById('eqTotDec').innerHTML = data.totales;
            },
            error: function(xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log(thrownError);
                console.log("No se ha podido obtener la información");
                Swal.fire("Error","Hubo un error consultando los datos","error");
            }
        });
    } else {
        document.getElementById('eqActDec').innerHTML = "";
        document.getElementById('eqRepDec').innerHTML = "";
        document.getElementById('eqDesDec').innerHTML = "";
        document.getElementById('eqTotDec').innerHTML = "";
    }
}

function llenarTotalesDepartamento(){
    if ($("#dropdownDepartamentoReporteDpto").val()!='-'){
        $.ajax({
            url: '/sistema_zeus/webservice/reportes/totales/departamento/' + $("#dropdownDepartamentoReporteDpto").val() + '/',
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {            
                document.getElementById('eqActDpt').innerHTML = data.activos;
                document.getElementById('eqRepDpt').innerHTML = data.reparados;
                document.getElementById('eqDesDpt').innerHTML = data.desincorporados;
                document.getElementById('eqTotDpt').innerHTML = data.totales;
            },
            error: function(xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log(thrownError);
                console.log("No se ha podido obtener la información");
                Swal.fire("Error","Hubo un error consultando los datos","error");
            }
        });
    } else {
        document.getElementById('eqActDpt').innerHTML = "";
        document.getElementById('eqRepDpt').innerHTML = "";
        document.getElementById('eqDesDpt').innerHTML = "";
        document.getElementById('eqTotDpt').innerHTML = "";
    }
}

function llenarMayorMenorUniversidad(){
    ocultarTodo();
    $('#mayuniversidad').toggle('slow'); 
    $.ajax({
        url: '/sistema_zeus/webservice/reportes/mayor_menor/universidad',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {            
            document.getElementById('decanatoMayorCantidadUniv').innerHTML = data.decmayuni;
            document.getElementById('departamentoMayorCantidadUniv').innerHTML = data.depmayuni;
            document.getElementById('mayorCantidadUniv').innerHTML = data.mayuni;
            document.getElementById('decanatoMenorCantidadUniv').innerHTML = data.decmenuni;
            document.getElementById('departamentoMenorCantidadUniv').innerHTML = data.depmenuni;
            document.getElementById('menorCantidadUniv').innerHTML = data.menuni;
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(xhr.responseText);
            console.log(thrownError);
            console.log("No se ha podido obtener la información");
            Swal.fire("Error","Hubo un error consultando los datos","error");
        }
    });
}

function llenarMayorMenorDecanato(){
    if ($("#dropdownMayorMenorPorDecanato").val()!='-'){
        $.ajax({
            url: '/sistema_zeus/webservice/reportes/mayor_menor/decanato/' + $("#dropdownMayorMenorPorDecanato").val() + '/',
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {            
                if (!data.error){
                    document.getElementById('departamentoMayorCantidadDec').innerHTML = data.depmaydec;
                    document.getElementById('mayorCantidadDec').innerHTML = data.maydec;
                    document.getElementById('departamentoMenorCantidadDec').innerHTML = data.depmendec;
                    document.getElementById('menorCantidadDec').innerHTML = data.mendec;
                } else {
                    document.getElementById('departamentoMayorCantidadDec').innerHTML = "";
                    document.getElementById('mayorCantidadDec').innerHTML = "";
                    document.getElementById('departamentoMenorCantidadDec').innerHTML = "";
                    document.getElementById('menorCantidadDec').innerHTML = "";                    
                    Swal.fire("Error",data.error,"warning");
                }
            },
            error: function(xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log(thrownError);
                console.log("No se ha podido obtener la información");
                Swal.fire("Error","Hubo un error consultando los datos","error");
            }
        });
    } else {
        document.getElementById('departamentoMayorCantidadDec').innerHTML = "";
        document.getElementById('mayorCantidadDec').innerHTML = "";
        document.getElementById('departamentoMenorCantidadDec').innerHTML = "";
        document.getElementById('menorCantidadDec').innerHTML = "";
    }
}

function consultarReporte(){
    if ($("#dropdownAnno").val()!="-" && $("#dropdownMes").val()!="-"){
        $.ajax({
            url: '/sistema_zeus/webservice/reportes/solicitudes/' + $("#dropdownAnno").val() + '/' + $("#dropdownMes").val() + '/',
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {            
                Swal.fire("Lo logramos","data.error","warning");
            },
            error: function(xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log(thrownError);
                console.log("No se ha podido obtener la información");
                Swal.fire("Error","Hubo un error consultando los datos","error");
            }
        });
    }
}