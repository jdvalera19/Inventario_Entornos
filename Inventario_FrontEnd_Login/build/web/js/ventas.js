function loadData(){
    let request = sendRequest('api/ventas/list', 'GET', '')
    let table = document.getElementById('venta-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.id}</th>
                    <td>${element.idUsuario.id}</td>
                    <td>${element.idProducto.id}</td>
                    <td>${element.cantidadVendida}</td>
                    <td>${element.valorVenta}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = 
                        "form_ventas.html?idventa=${element.id}"'>Ver</button>
                    </td>
                </tr>

                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}


function saveVenta(){
    let id = document.getElementById('venta-id').value
    let idUsuario = document.getElementById('venta-usuario').value
    let idProducto = document.getElementById('venta-producto').value
    let cantidadVendida = document.getElementById('venta-cantidad').value
    let valorVenta = document.getElementById('venta-valor').value
    let data = {'id': id,'idUsuario':idUsuario,'idProducto': idProducto, 
        'cantidadVendida': cantidadVendida, 'valorVenta': valorVenta}
    console.log(data);
    let request = sendRequest('api/ventas/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        alert('Venta Agregada Exitosamente.')
        window.location = 'ventas.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}

function loadVenta(idventa){
    let request = sendRequest('api/ventas/list/'+idventa, 'GET', '')
    let id = document.getElementById('venta-id')
    let idUsuario = document.getElementById('venta-usuario')
    let idProducto = document.getElementById('venta-producto')
    let cantidadVendida = document.getElementById('venta-cantidad')
    let valorVenta = document.getElementById('venta-valor')
    request.onload = function(){
        let data = request.response;
        //Se actualiza el valor de las variables según el JSON
        console.log(data);
        id.value = data.id
        idUsuario.value = data.idUsuario
        idProducto.value = data.idProducto
        cantidadVendida.value = data.cantidadVendida
        valorVenta.value = data.valorVenta
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteVenta(){
    let id = document.getElementById('venta-id').value
    let request = sendRequest('api/ventas/'+ id , 'DELETE', '')
    request.onload = function(){
        alert('Venta Eliminado Exitosamente.')
        window.location = 'ventas.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}


