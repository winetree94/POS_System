import React from 'react';
import {Route} from "react-router-dom";

class InvoicePrint extends React.Component {
	render() {
		return (
			<div>
				<Route path="/invoiceprint" component={InvoicePrint} />
				<h1>InvoicePrint</h1>
			</div>
		)
	}
}

export default InvoicePrint;