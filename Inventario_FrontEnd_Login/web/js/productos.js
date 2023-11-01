function loadData(){
    let request = sendRequest('api/productos/list', 'GET', '')
    let table = document.getElementById('producto-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.id}</th>
                    <td>${element.idCategoria.id}</td>
                    <td>${element.nombre}</td>
                    <td>${element.precio}</td>
                    <td>${element.descripcion}</td>
                    <td>${element.cantidad}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = 
                        "form_productos.html?idproducto=${element.id}"'>Ver</button>
                    </td>
                </tr>

                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="5">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}


function saveProducto(){
    let idCategoria = document.getElementById('producto-idCategoria').value
    let id = document.getElementById('producto-id').value
    let precio = document.getElementById('producto-precio').value
    let nombre = document.getElementById('producto-nombre').value
    let descripcion = document.getElementById('producto-descripcion').value
    let cantidad = document.getElementById('producto-cantidad').value
    let data = {'id': id,'idCategoria':idCategoria,'precio':precio,'nombre': nombre, 
        'descripcion': descripcion, 'cantidad': cantidad}
    console.log(data);
    let request = sendRequest('api/productos/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        alert('Producto Agregado Exitosamente.')
        window.location = 'productos.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}

function loadProducto(idproducto){
    let request = sendRequest('api/productos/list/'+idproducto, 'GET', '')
    let categoria = document.getElementById('producto-categoria')
    let id = document.getElementById('producto-id')
    let precio = document.getElementById('producto-precio')
    let nombre = document.getElementById('producto-nombre')
    let descripcion = document.getElementById('producto-descripcion')
    let cantidad = document.getElementById('producto-cantidad')
    request.onload = function(){
        let data = request.response;
        //Se actualiza el valor de las variables según el JSON
        console.log(data);
        id.value = data.id
        categoria.value = data.categoria
        precio.value = data.precio
        nombre.value = data.nombre
        descripcion.value = data.descripcion
        cantidad.value = data.cantidad
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteProducto(){
    let id = document.getElementById('producto-id').value
    let request = sendRequest('api/productos/'+ id , 'DELETE', '')
    request.onload = function(){
        alert('Producto Eliminado Exitosamente.')
        window.location = 'productos.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}


