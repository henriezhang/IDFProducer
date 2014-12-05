package com.tencent.wordseg;

import org.ansj.domain.Term;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: antyrao
 * Date: 13-10-17
 * Time: 下午12:50
 * <p/>
 * filter which only keep meaningful word in respect to Key Word of a document.
 */
public class MeanWordFilter implements WordFilter
{

    private Pattern pattern = Pattern.compile("(?s)[\\d|%|'].*");

    @Override
    public boolean accept(Object wordObj)
    {
        Term word = (Term) wordObj;

        Matcher matcher = pattern.matcher(word.getName());
        if (matcher.matches())
        {
            return false;
        }

        if (word.getName().trim().length() < 2)
        {
            return false;
        }

        //TODO reconsider following code.
//        String wordProperity = word.getNatrue().natureStr;
//
//        if (!wordProperity.startsWith("n"))
//        {
//            return false;
//        }

        return true;
    }
}
