import React, { Component } from 'react';
import common from '../utility/common-utility';
export default class Cashbook_Info extends Component {



    render() {


        const { cash_date, cash_deposit, cash_balance} = this.props.info;

        return (
            <tr>
                <th>{cash_date}</th>
                <th className={"text-right"}>{common(cash_deposit)}</th>
                <th className={"text-right"}>{common(cash_balance)}</th>
            </tr>
        );
    }
}
