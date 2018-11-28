import React from 'react';
import comma from '../utility/common-utility';

const OrderItem = (props) => {
    return (
      <tr>
        <td>{props.order.menu_seq}</td>
        <td>1</td>
        <td className="text-right">{comma(props.order.menu_price)}</td>
      </tr>
    )
}

export default OrderItem;