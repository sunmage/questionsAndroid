package hk.ust.cse.hunkim.questionroom;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import hk.ust.cse.hunkim.questionroom.question.Question;


/**
 * Created by hunkim on 7/15/15.
 */

public class QuestionTest  extends TestCase {
    Question q;



    protected void setUp() throws Exception {
        super.setUp();

        q = new Question("Hello? This is very nice");
    }

    @SmallTest

    public void testChatFirstString() {
        String[] strHead = {
                "Hello? This is very nice", "Hello?",
                "This is cool! Really?", "This is cool!",
                "How.about.this? Cool", "How.about.this?"
        };

        for (int i=0; i<strHead.length; i+=2) {
            String head = q.getFirstSentence(strHead[i]);
            assertEquals("Chat.getFirstSentence", strHead[i+1], head);
        }
    }

    @SmallTest

    public void testHead() {
        assertEquals("Head", "Hello?", q.getHead());
    }

    //additional
    public void testObj(){
        String test = "Here's a couple sentences. I'm testing to see an actual object gets created.";
        Question q = new Question(test);
        assertEquals(q.getEcho(),0);
        assertEquals(q.getHeadLastChar(),'s');
    }

    public void testDate(){
        String[] strHead = {
                "Hello? This is very nice", "Hello?",
                "This is cool! Really?", "This is cool!",
                "How.about.this? Cool", "How.about.this?"
        }; //copied from example above
        Question[] q = new Question[6];
        for (int i=0;i<6;i++) {
            q[i] = new Question(strHead[i]);
        }
        for (int i=0; i<5;i++)
        {
            assertNotSame(q[i].getTimestamp(),q[i+1].getTimestamp());
        }
    }

    public void testKey(){  //also tests desc
        String test = "Nonsense!";
        Question q = new Question(test); //no error?
        q.setKey(q.getDesc());
        assertSame(q.getDesc(),q.getKey());
    }
}
