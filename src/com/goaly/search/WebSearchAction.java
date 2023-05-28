package com.goaly.search;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.util.io.URLUtil;

/**
 * Web搜索Action
 * @author lys
 */
public class WebSearchAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        String actionName = e.getPresentation().getText();
        // 获取当前光标
        Caret caret = e.getData(CommonDataKeys.CARET);
        if (caret == null) {
            return;
        }
        boolean hasSelection = caret.hasSelection();
        if (!hasSelection) {
            return;
        }

        String selectedText = caret.getSelectedText();
        if (selectedText.isBlank()) {
            return;
        }

        String url = null;
        switch (actionName){
            case "必应搜索":
            default:
                url = "https://cn.bing.com/search?q=" ;
                System.out.println("必应搜索: " + selectedText);
                break;
            case "百度搜索":
                url = "https://www.baidu.com/s?wd=" ;
                System.out.println("百度搜索: " + selectedText);
                break;
            case "搜狗搜索":
                url = "https://www.sogou.com/web?query=" ;
                System.out.println("搜狗搜索: " + selectedText);
                break;
        }
        BrowserUtil.browse(url + URLUtil.encodeURIComponent(selectedText));
    }
}
