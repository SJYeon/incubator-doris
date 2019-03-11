// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.optimizer.operator;

import org.apache.doris.optimizer.OptUtils;

public class OptUTLeafNode extends OptOperator {
    private int value;

    public OptUTLeafNode(int value) {
        super(OptOperatorType.OP_UNIT_TEST_LEAF);
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public int hashCode() {
        return OptUtils.combineHash(super.hashCode(), value);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        OptUTLeafNode rhs = (OptUTLeafNode) object;
        return value == rhs.value;
    }

    @Override
    public String getExplainString(String prefix) { return type.getName() + " (value=" + value + ")";
    }
}