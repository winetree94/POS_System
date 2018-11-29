import React, { Component } from 'react';

export default class Cashbook_Info extends Component {




    render() {

        const { cash_date, cash_deposit, cash_balance} = this.props.info;

        return (
            <tr>
                <th>{cash_date}</th>
                <th>{cash_deposit}</th>
                <th>{cash_balance}</th>
            </tr>
        );
    }
}
