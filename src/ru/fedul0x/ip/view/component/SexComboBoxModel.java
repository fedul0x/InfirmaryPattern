/*
 * Copyright 2012 Ivashin Alexey <ivashin.alexei@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.fedul0x.ip.view.component;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class SexComboBoxModel<String> implements ComboBoxModel<String> {

    private Boolean selectedItem = true;

    public SexComboBoxModel() {
        super();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        String item = (String) anItem;
        if ("Мужской" == anItem) {
            selectedItem = true;
        } else {
            selectedItem = false;
        }
    }

    @Override
    public Object getSelectedItem() {
//        return 0;
        String result = (String) "Женский";
        if (selectedItem) {
            result = (String) "Мужской";
        }
        return result;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public String getElementAt(int index) {
        String result = (String) "Женский";
        if (index == 0) {
            result = (String) "Мужской";
        }
        return result;
    }

    @Override
    public void addListDataListener(ListDataListener l) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
