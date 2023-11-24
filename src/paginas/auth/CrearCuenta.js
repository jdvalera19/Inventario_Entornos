import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
//import APIInvoke from '../../utils/APIInvoke';
import swal from 'sweetalert';

const CrearCuenta = () => {

    const [usuario, setUsuario] = useState ({
        nombre: '',
        email: '',
        password: '',
        confirmar: '',
    });

    const {nombre, email, password,confirmar}= usuario;

    const onChange = (e) =>{
        setUsuario({
            ...usuario,
            [e.target.name]: e.target.value

        })
    }

    useEffect(() =>{
        document.getElementById("nombre").focus();

    }, [])

    const CrearCuenta = async () => {

        if (password !== confirmar){
            const msg = "Las contraseñas son diferentes"
            swal(
                {
                    title: 'Error',
                    text: msg,
                    icon: 'error',
                    buttons:{
                        confirm:{
                            text: 'Ok',
                            value: true,
                            visible: true,
                            className:'btn btn-danger',
                            closeModal:true
                        }
                    }
                });

        } else{
            const data={
                nombre: usuario.nombre,
                email:usuario.email,
                password:usuario.password
            }
            //const response = await APPInvoke.invokePOST('/api/usuarios',data);
            //const mensaje= response.msg;
    
        }

        setUsuario({
            nombre: '',
            email: '',
            password: '',
            confirmar: '',
        })


    }

    const onSubmit = (e) =>{
        e.preventDefault();
        CrearCuenta();

    }



    
    return (

        <div class="hold-transition login-page">
            <div className="card card-outline card-primary">
                <div className="card-header text-center">
                    <Link to={"#"}><b>Registrar</b>Cuenta</Link>
                </div>
                <div className="card-body">
                    <p className="login-box-msg">Ingrese los datos del usuario</p>


                    <form onSubmit={onSubmit}>
                        <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Nombre" id="nombre" name="nombre" value={nombre} onChange={onChange} required />
                            <div className="input-group-append">
                                <div className="input-group-text">
                                    <span className="fas fa-user"></span>
                                </div>
                            </div>
                        </div>


                        <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Usuario" id="email" name="email" value={email} onChange={onChange} required />
                            <div className="input-group-append">
                                <div className="input-group-text">
                                    <span className="fas fa-envelope"></span>
                                </div>
                            </div>

                        </div>
                        <div className="input-group mb-3">
                            <input type="password" className="form-control" placeholder="Contraseña" id="password" name="password" value={password} onChange={onChange} required />
                            <div className="input-group-append">
                                <div className="input-group-text">
                                    <span className="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>

                        <div className="input-group mb-3">
                            <input type="password" className="form-control" placeholder="Confirmar Contraseña" id="confirmar" name="confirmar" value={confirmar} onChange={onChange} required />
                            <div className="input-group-append">
                                <div className="input-group-text">
                                    <span className="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>



                        <div className="social-auth-links text-center mt-2 mb-3">
                            <button type='submit' className="btn btn-block btn-primary">
                                Registrarse
                            </button>
                            <Link to={"/"} className="btn btn-block btn-danger">
                                Regresar al Inicio de sesión
                            </Link>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    );
}

export default CrearCuenta
