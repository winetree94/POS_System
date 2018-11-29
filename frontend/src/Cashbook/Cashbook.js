import React from "react";
import Cashbook_List from "./Cashbook_List";
import Axios from "axios";
import CashbookEdit from "./Cashbook_Edit";
// import common from '../utility/common-utility';
import qs from 'qs'


export default class Cashbook extends React.Component {

    state = {
        data : []
    };

    constructor (props){super(props);
   }

    componentDidMount = () => {

        setInterval(()=>{

        Axios.get('/api/cashbook').then((response)=>{
            this.setState({
                data : response.data
            })
        });
		console.log("render");

        }, 3000);
    };

    createHandler = (info) => {
        console.log(info.cash_deposit);
            Axios.post('/api/cashbook' , qs.stringify({
                    cash_deposit : info.cash_deposit
                })
            ).then((response)=>{
                console.log(response);
            }).catch ((err) => {
            console.log (err)
        });
            console.log("render complete");
    };


	
	render() {

		return (
			<div className={"container content"}>
				<h1 className={"content-header-1"}>현금출납부</h1>


                <div className="row">
                    <div className="col" >
				<Cashbook_List data={this.state.data} />
                    </div>
                        <div className="col" >
                            <CashbookEdit onCreate={this.createHandler}/>
                        </div>
                </div>

			</div>








		);
	}
}