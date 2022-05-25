import React, {useState} from 'react';

const Form = ({newLocation}) => {
    const [city, setCity] = useState(""); // hook para buscar la ciudad

    const onSubmit = (e) => {  //recibe el nombre de la ciudad
        e.preventDefault();   //para que no se recargue la pagina
        console.log({city});   //se muestre la ciudad
        if(city === "" || !city) return; //no suceda nada si no se escribe ninguna ciudad

        newLocation(city);
    } 

    return(
                      //input de busqueda
        <div className="container">
            <form onSubmit={onSubmit}> /*aqui se ejecuta una funcion*/ 
                <div className="input-group mb-3 mx-auto">
                    <input type="text" className="form-control" placeholder="Ciudad" onChange={(e) =>setCity(e.target.value)}/> /*evento para recoger la informacion ingresada en el campo, y se ejecuta cuando se da clic en el boton*/
                    <button className="btn btn-primary input-group-text" type="submit">Buscar</button>                          /* se modifica setcity y se le envia el valor ingresado en el campo    
                </div>
            </form>
        </div>

    );
}

export default Form;