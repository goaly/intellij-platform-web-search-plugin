/**
 * Copyright (C), 2023-2033
 */
package com.goaly.search;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.Caret;
import org.jetbrains.annotations.NotNull;

/**
 * Web搜索ActionGroup
 *
 * @author: lys
 * @date: 2023/5/27 23:03
 */
public class WebSearchActionGroup extends DefaultActionGroup {

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(isEnableWebSearch(e));
    }

    /**
     * 是否启用Web搜索
     *
     * @param e AnActionEvent
     * @return boolean
     */
    private boolean isEnableWebSearch(@NotNull AnActionEvent e) {
        String actionName = e.getPresentation().getText();
        // 获取当前光标
        Caret caret = e.getData(CommonDataKeys.CARET);
        if (caret == null) {
            return false;
        }
        boolean hasSelection = caret.hasSelection();
        if (!hasSelection) {
            return false;
        }

        String selectedText = caret.getSelectedText();
        if (selectedText.isBlank()) {
            return false;
        }
        return true;
    }
}