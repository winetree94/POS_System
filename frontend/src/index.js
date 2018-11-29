import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import './static/css/style.css';
import * as serviceWorker from './serviceWorker';
import $ from 'jquery';
import {BrowserRouter, Route} from "react-router-dom";
import Category from "./Category/Category";
import InvoicePrint from "./Invoice/InvoicePrint";

ReactDOM.render(
	<BrowserRouter basename={"/pos/"}>
		<App/>
	</BrowserRouter>
	, document.getElementById('root'));
serviceWorker.unregister();