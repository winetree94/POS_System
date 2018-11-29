import React from "react";
import Cashbook_List from "./Cashbook_List";
import Axios from "axios";
import CashbookEdit from "./Cashbook_Edit";
// import common from '../utility/common-utility';
import qs from 'qs'
import Loading from '../comm/Loading';


export default class Cashbook extends React.Component {

    state = {
        data : [],
        isLoad: false
    };

    constructor (props){super(props);
   }

    componentDidMount = () => {

        this.interval = setInterval(()=>{
        Axios.get('/api/cashbook').then((response)=>{
            this.setState({
                data : response.data,
                isLoad : true
            })
        });
		console.log("render");

        }, 1000);
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
        const {isLoad} = this.state;

        if(!isLoad){
            return <Loading msg="현금출납부를 로딩중입니다."></Loading>

        } else{

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

	componentWillUnmount(){
	    clearInterval(this.interval);
    }
}