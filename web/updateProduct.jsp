<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Update</title>
    </head>
    <body>
        <h2>Simple CURD Using STRUTS2 FRAMEWORK</h2>
        <form action=updatedetailsProduct method="post">
            
                <table>
                    <tr>
                        <td><b> Product Id: </b></td>
                        <td><input type="text" name="productId" value='<s:property value="productId"/>'></td>
                    </tr>
                    
                    <tr>
                        <td><b>Product Name:</b></td>
                        <td><input type="text" name="productName" value='<s:property value="productName"/>'></td>
                    </tr>
                    <tr>
                        <td><b>Price:</b></td>
                        <td><input type="text" name="price" value='<s:property value="price"/>'></td>
                    </tr>
                    <tr>
                        <td><b>Availability:</b></td>
                        <td><input type="text" name="availability" value='<s:property value="availability"/>'></td>
                    </tr>
                    
                </table> 
                    
            <button name="submitType" value="update" type="submit">Update</button>

        </form>
        <s:if test="ctr>0">
            <span style="color: red;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>
