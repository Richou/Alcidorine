package net.heanoria.appengine.alcidorine.services;

import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;
import net.heanoria.appengine.alcidorine.entity.MemoCategory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext-test.xml"})
public class MemoServiceTest extends TestCase{
	
	@Autowired
	private MemoService memoService = null;
	
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalUserServiceTestConfig()).setEnvIsLoggedIn(true)
			.setEnvAuthDomain("localhost").setEnvEmail("test@localhost");
	
	@Before
	public void onInit(){
		helper.setUp();
	}
	
	@After
	public void onRelease(){
		helper.tearDown();
	}
	
	@Test
	public void createMemoCategorieTest() {
		MemoCategory java = createMemoCategory("Categorie 1", "La categorie numero 1", false, Collections.<MemoCategory>emptyList());
		assertTrue(java.getId() != null);
		MemoCategory php = createMemoCategory("Categorie 2", "La categorie numero 2", false, Collections.<MemoCategory>emptyList());
		assertTrue(php.getId() != null);
	}
	
	private MemoCategory createMemoCategory(String title, String description, boolean isTopParent, List<MemoCategory> children) {
		MemoCategory memoCategory = new MemoCategory()
			.setTitle(title).setDescription(description)
			.setTopParent(isTopParent).setChildren(children);
		
		return memoService.createMemoCategory(memoCategory);
	}

}
