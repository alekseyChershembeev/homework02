import React from "react";
import Greeting from "./Greeting";

class Button extends React.Component {
// конструктор с состояниемм, который по умолчанию false
    //+ автоматический bind на нажатие
    constructor(props) {
        super(props);
        this.state = {isLoggedIn: false};
        this.handleLoginClick = this.handleLoginClick.bind(this);
        this.handleLogoutClick = this.handleLogoutClick.bind(this);

    }

    //бинд
    handleLoginClick() {
        this.setState({isLoggedIn: true})
    }

    //бинд
    handleLogoutClick() {
        this.setState({isLoggedIn: false})
    }

    render() {
        const isLoggedIn = this.state.isLoggedIn;
        let button;

        if (isLoggedIn) {
            //bind вешаем на кнопки
            button = <LoginButton onClick={this.handleLogoutClick}/>
        } else {
            //bind вешаем на кнопки
            button = <LogoutButton onClick={this.handleLoginClick}/>
        }
        //Возвр комонент с props из константы
        return (
            <div>

                <Greeting isLoggedIn={isLoggedIn}/>
                {button}
            </div>
        )

    }

}


function LoginButton(props) {
    return (
        <button onClick={props.onClick}>
            Войти
        </button>
    );
}

function LogoutButton(props) {
    return (
        <button onClick={props.onClick}>
            Выйти
        </button>
    );
}


export default Button;




