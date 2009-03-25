package uk.ac.manchester.cs.owl;

import org.semanticweb.owl.model.*;
/*
 * Copyright (C) 2006, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 26-Oct-2006<br><br>
 */
public class OWLDataHasValueImpl extends OWLValueRestrictionImpl<OWLDataPropertyExpression, OWLLiteral> implements OWLDataHasValue {

    public OWLDataHasValueImpl(OWLDataFactory dataFactory, OWLDataPropertyExpression property, OWLLiteral value) {
        super(dataFactory, property, value);
    }


    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return obj instanceof OWLDataHasValue;
        }
        return false;
    }


    public OWLClassExpression asSomeValuesFrom() {
        return getOWLDataFactory().getOWLDataSomeValuesFrom(getProperty(), getOWLDataFactory().getOWLDataOneOf(getValue()));
    }


    public void accept(OWLClassExpressionVisitor visitor) {
        visitor.visit(this);
    }

    public void accept(OWLObjectVisitor visitor) {
        visitor.visit(this);
    }


    public <O> O accept(OWLClassExpressionVisitorEx<O> visitor) {
        return visitor.visit(this);
    }


    public <O> O accept(OWLObjectVisitorEx<O> visitor) {
        return visitor.visit(this);
    }
}