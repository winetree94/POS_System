import React, { Component } from 'react';
import Axios from 'axios';

export default class Cashbook_Info extends Component {

    state = {
        data : []
    };

    constructor (props){
        super(props);
    }

    getData = () => {
        Axios.get('/api/cashbook').then((response)=>{
            this.setState({
                data : response.data
            })
        })

    };


    render() {

        const style = {
            border: '1px solid black',
            padding: '8px',
            margin: '8px',
        };



        return (
            <div style={style}>{JSON.stringify(this.state)}
            </div>
        );
    }
}
