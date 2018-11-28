import React from "react";
import axios from "axios";
import { Row, Col } from "reactstrap";
import InvoiceList from "./InvoiceList";
import InvoiceItem from "./InvoiceItem";
import InvoiceDetail from "./InvoiceDetail";

export default class Invoice extends React.Component {
  state = {
    invoiceList: [],
    invoiceDetail: {},
    orderList: []
  };

  componentDidMount = () => {
    axios.get("/api/invoice").then(response => {
      this.setState({
				invoiceList: response.data,
      },()=>{
				this.clickEventHandler(this.state.invoiceList[0]);
			});
		});
  };

  clickEventHandler = param => {
    this.setState({
        invoiceDetail: { ...param }
      },
      () => {
        axios
          .get("/api/order", {
            ref: this.state.invoiceDetail.ref
          })
          .then(response => {
            console.log(response.data);
            this.setState({
              orderList: response.data
            });
          });
      }
    );
  };

  render() {
    return (
      <div className={"container content"}>
        <h1 className={"content-header-1"} onClick={this.clickEventHandler}>
          판매 내역
        </h1>

        <div className={"row"}>
          <div className={"col"}>
            <h4 className={"content-header-4"}>거래 내역</h4>
            <InvoiceList
              invoiceList={this.state.invoiceList}
              select={this.clickEventHandler}
            />
          </div>
          <div className={"col"}>
            <h4 className={"content-header-4"}>영수증</h4>
            <InvoiceDetail
              orderList={this.state.orderList}
              invoiceDetail={this.state.invoiceDetail}
            />
          </div>
        </div>
      </div>
    );
  }
}
