
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;
import be.Producto;
import beans.ManagedBeanProducto;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the specific language governing permissions and  limitations under the License.
 */
@FacesConverter(value = "ProductorealConverter")
public class ProductoRealConverter implements Converter {
@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
 System.out.println(" entramos a converter Producto Real getObget:"+new Integer(value));
        if (context == null) {
throw new NullPointerException("context");
}
if (component == null) {
throw new NullPointerException("component");
}
      FacesContext ctx = FacesContext.getCurrentInstance();
      ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{managedBeanProducto}",ManagedBeanProducto.class);
ManagedBeanProducto productos = (ManagedBeanProducto)vex.getValue(ctx.getELContext());
Producto Producto = new Producto();
try {
  Producto =  productos.getProducto(new Integer(value));
} catch( NumberFormatException e ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido- Numero de formato", "Este no es un Numero Producto" );
throw new ConverterException( message );
}
if( Producto == null ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valor Desconocido - Objeto nullo", "El Producto es desconocido !" );
throw new ConverterException( message );
}
return Producto;
}



    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         System.out.println(" entramos a converter Producto Real getAs String:"+(Producto) value);
if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Producto) value).getIdProducto());
        }
    }
}
