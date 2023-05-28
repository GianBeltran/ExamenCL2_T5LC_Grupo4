$(document).on("click", "#btnagregar", function(){
	$("#txtdescripcion").val("");
	$("#txtcategoria").val("");
	$("#hddidregistrocategoria").val("0");
	$("#cboestado").empty();
	$.ajax({
		type: "GET",
		url: "/Estado/listarCategoria",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cboestado").append(
							`<option value="${value.idcategoria}">
								${value.desccategoria}</option>`
							);
				})
			}			
		}
	})
	$("#modalCategoria").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtdescripcion").val($(this).attr("data-desccategoria"));
	$("#txtcategoria").val($(this).attr("data-categoria"));
	$("#hddidregistrocategoria").val($(this).attr("data-idcategoria"));
	$("#cboestado").empty();
	var idestado = $(this).attr("data-idecategoria");
	$.ajax({
		type: "GET",
		url: "/Estado/listaCategoria",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbocategoria").append(
							`<option value="${value.idcategoria}">
								${value.desccategoria}</option>`
							);
				})
				$("#cbocategoria").val(idcategoria);
			}			
		}
	})
	$("#modalcategoria").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/sala/registrarCategoria",
		contentType: "application/json",
		data: JSON.stringify({
			idsala: $("#hddidregistrocategoria").val(),
			descsala: $("#txtdescripcion").val(),
			asientos: $("#txtcategoria").val(),
			idestado: $("#cboestado").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarSala();
		}
	});
	$("#modalCategoria").modal("hide");
})

$(document).on("click", ".btneliminarCategoria", function(){
	$("#hddideliminarCategoria").val("");
	$("#hddideliminarCategoria").val($(this).attr("data-idcategoria"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-desccategoria)+"?");
	$("#modalEliminarCategoria").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/categoria/eliminarCategoria",
		data: JSON.stringify({
			idsala: $("#hddideliminarcategoria").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarSala();
		}
	})
	$("#modalEliminarCategoria").modal("hide");
})

function ListarSala(){
	$.ajax({
		type: "GET",
		url: "/sala/listarCategoria",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblcategoria > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcategoria > tbody").append("<tr>"+
						"<td>"+value.idcategoria+"</td>"+
						"<td>"+value.desccripcion+"</td>"+
						"<td>"+value.categoria+"</td>"+
						"<td>"+value.estado.desccategoria+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idcategoria='"+value.idcategoria+"'"+
							" data-desccategoria='"+value.desccategoria+"'"+
							" data-categoria='"+value.categoria+"'"+
							" data-idestado='"+value.estado.idestado+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcategoria'"+	
							" data-idcategoria='"+value.idcategoria+"'"+
							" data-desccategoria='"+value.desccategoria+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





