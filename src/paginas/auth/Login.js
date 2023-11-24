import React ,{useState,useEffect} from 'react';
import { Link, useNavigate } from 'react-router-dom';
const Loging = () => {
    //Para redireccionar de un componente a otro
    const navigate = useNavigate();

    const[usuario, setUsuario]=useState({

        email:'',
        password:''

    });
    const IniciarSesion = async () => {
        setUsuario({
            
            email: '',
            password: '',
           
        })
    }
    const data={
        email:usuario.nombreusuario,
        password:usuario.password
    }
    

    const{email,password}=usuario;

    const onChange=(e) =>{
        setUsuario({
            ...email,
        [e.target.name]:e.target.value
    })

    }


    useEffect(() =>{
        document.getElementById("email").focus();

    }, [])

    const onSubmit=(e) =>{
        setUsuario({

            ...usuario,
            [e.target.name]:e

        })
    }

    return (
        <div class="hold-transition login-page">
            <div className="card card-outline card-primary">
                <div className="card-header text-center">
                    <Link to={"#"}><b>Iniciar</b> Sesión</Link>
                </div>
                <div className="card-body">
                    <p className="login-box-msg">Bienvenido ,ingrese sus credenciales</p>

                    <form onSubmit={onSubmit}>
                        <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Usuario" id="email" name="email" value={email} onChange={onChange} required/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                    <span className="fas fa-envelope"></span>
                                </div>
                            </div>
                        </div>
                        <div className="input-group mb-3">
                            <input type="password" className="form-control" placeholder="Contraseña" id="password" name="password"value={password} onChange={onChange} required/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                    <span className="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>
                        <div className="social-auth-links text-center mt-2 mb-3">
                            <button type='submit' className="btn btn-block btn-primary">
                                Ingresar
                            </button>
                            <Link to={"/crear-cuenta"} className="btn btn-block btn-danger">
                                Registrarse
                            </Link>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Loging;