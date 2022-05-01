import React, {useEffect} from "react";
import {connect} from "react-redux";
import {useParams} from "react-router";
import {getCustomerProductDetails} from "../../reducer/product/productActions";

function ProductItem ({getCustomerProductDetails, productDetails}) {

    const {userId} = useParams();

    useEffect(() => {
        getCustomerProductDetails(userId);
    }, [])

    return(
        <>
            <ProductItemField label={'Name'} value={productDetails.name}/>
            <span>Price : </span>{productDetails.actualPrice} <span className={'old-price'}>{productDetails.price}</span>
            <ProductItemField label={'Description'} value={productDetails.description}/>
            <ProductItemField label={'Country'} value={productDetails.country}/>
        </>
    )
};

const ProductItemField = ({label, value}) => {
    return <div><span>{label} : </span>{value}</div>
}

const mapStateToProps = ({product}) => {
    return product;
};

const mapDispatchToProps = {getCustomerProductDetails};

export default connect(mapStateToProps, mapDispatchToProps)(ProductItem);