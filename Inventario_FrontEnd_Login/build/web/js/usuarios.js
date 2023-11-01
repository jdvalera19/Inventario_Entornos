function loadData(){
    let request = sendRequest('api/usuarios/list', 'GET', '')
    let table = document.getElementById('usuario-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.id}</th>
                    <td>${element.nombre}</td>
                    <td>${element.nombreusuario}</td>
                    <td>${element.email}</td>
                    <td>${element.password}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = 
                        "form_usuarios.html?idusuario=${element.id}"'>Ver</button>
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


function saveUsuario(){
    let id = document.getElementById('usuario-id').value
    let nombre = document.getElementById('usuario-nombre').value
    let nombreusuario = document.getElementById('usuario-username').value
    let email = document.getElementById('usuario-email').value
    let password = document.getElementById('usuario-password').value
    let data = {'id': id,'nombre':nombre,'nombreusuario': nombreusuario, 
        'email': email, 'password': password}
    console.log(data);
    let request = sendRequest('api/usuarios/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        alert('Usuario Agregado Exitosamente.')
        window.location = 'usuarios.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}

function loadUsuario(idusuario){
    let request = sendRequest('api/usuarios/list/'+idusuario, 'GET', '')
    let id = document.getElementById('usuario-id')
    let nombre = document.getElementById('usuario-nombre')
    let nombreusuario = document.getElementById('usuario-username')
    let email = document.getElementById('usuario-email')
    let password = document.getElementById('usuario-password')
    request.onload = function(){
        let data = request.response;
        //Se actualiza el valor de las variables según el JSON
        console.log(data);
        id.value = data.id
        nombre.value = data.nombre
        nombreusuario.value = data.nombreusuario
        email.value = data.email
        password.value = data.password
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteUsuario(){
    let id = document.getElementById('usuario-id').value
    let request = sendRequest('api/usuarios/'+ id , 'DELETE', '')
    request.onload = function(){
        alert('Usuario Eliminado Exitosamente.')
        window.location = 'usuarios.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}


