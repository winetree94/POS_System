import React from "react";
import InvoiceItem from "./InvoiceItem";

export default class InvoiceList extends React.Component {
  render() {
    const style = {
      backgroundColor: "white",
      overflow: "auto"
		};

    const { invoiceList, select } = this.props;
    const lists = invoiceList.map(invoice => (
			<InvoiceItem 
				key={invoice.invoice_seq}
				invoice={invoice}
				select={select}
			/>
    ));

    return (
      <div className="content-box" style={style}>
        <table className="table">
          <thead>
            <tr>
              <th>일자</th>
              <th>시간</th>
              <th width="150px" className="text-right">금액</th>
            </tr>
          </thead>
					<tbody>
						{lists}
					</tbody>
        </table>
      </div>
    );
  }
}
