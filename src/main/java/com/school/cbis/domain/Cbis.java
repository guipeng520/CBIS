/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain;


import com.school.cbis.domain.tables.ArticleInfo;
import com.school.cbis.domain.tables.ArticleSub;
import com.school.cbis.domain.tables.ArticleType;
import com.school.cbis.domain.tables.Authorities;
import com.school.cbis.domain.tables.AutonomousPracticeContent;
import com.school.cbis.domain.tables.AutonomousPracticeHead;
import com.school.cbis.domain.tables.AutonomousPracticeInfo;
import com.school.cbis.domain.tables.AutonomousPracticeTemplate;
import com.school.cbis.domain.tables.BringIn;
import com.school.cbis.domain.tables.ClassroomCourseTimetableInfo;
import com.school.cbis.domain.tables.FourItems;
import com.school.cbis.domain.tables.FourItemsType;
import com.school.cbis.domain.tables.Grade;
import com.school.cbis.domain.tables.HeadType;
import com.school.cbis.domain.tables.HeadTypePlugin;
import com.school.cbis.domain.tables.Major;
import com.school.cbis.domain.tables.PersistentLogins;
import com.school.cbis.domain.tables.PlaceFileContent;
import com.school.cbis.domain.tables.PlaceFileInfo;
import com.school.cbis.domain.tables.PlaceFileTitle;
import com.school.cbis.domain.tables.SchemaVersion;
import com.school.cbis.domain.tables.Student;
import com.school.cbis.domain.tables.StudentCourseTimetableInfo;
import com.school.cbis.domain.tables.SystemInform;
import com.school.cbis.domain.tables.TeachCourseInfo;
import com.school.cbis.domain.tables.TeachTaskContent;
import com.school.cbis.domain.tables.TeachTaskInfo;
import com.school.cbis.domain.tables.TeachTaskTitle;
import com.school.cbis.domain.tables.TeachType;
import com.school.cbis.domain.tables.Teacher;
import com.school.cbis.domain.tables.TeacherCourseTimetableInfo;
import com.school.cbis.domain.tables.Tie;
import com.school.cbis.domain.tables.TieElegant;
import com.school.cbis.domain.tables.TieElegantTime;
import com.school.cbis.domain.tables.TieNotice;
import com.school.cbis.domain.tables.TieNoticeAffix;
import com.school.cbis.domain.tables.TieNoticeTime;
import com.school.cbis.domain.tables.UserType;
import com.school.cbis.domain.tables.Users;
import com.school.cbis.domain.tables.Yard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Cbis extends SchemaImpl {

	private static final long serialVersionUID = -215571732;

	/**
	 * The reference instance of <code>cbis</code>
	 */
	public static final Cbis CBIS = new Cbis();

	/**
	 * No further instances allowed
	 */
	private Cbis() {
		super("cbis");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			ArticleInfo.ARTICLE_INFO,
			ArticleSub.ARTICLE_SUB,
			ArticleType.ARTICLE_TYPE,
			Authorities.AUTHORITIES,
			AutonomousPracticeContent.AUTONOMOUS_PRACTICE_CONTENT,
			AutonomousPracticeHead.AUTONOMOUS_PRACTICE_HEAD,
			AutonomousPracticeInfo.AUTONOMOUS_PRACTICE_INFO,
			AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE,
			BringIn.BRING_IN,
			ClassroomCourseTimetableInfo.CLASSROOM_COURSE_TIMETABLE_INFO,
			FourItems.FOUR_ITEMS,
			FourItemsType.FOUR_ITEMS_TYPE,
			Grade.GRADE,
			HeadType.HEAD_TYPE,
			HeadTypePlugin.HEAD_TYPE_PLUGIN,
			Major.MAJOR,
			PersistentLogins.PERSISTENT_LOGINS,
			PlaceFileContent.PLACE_FILE_CONTENT,
			PlaceFileInfo.PLACE_FILE_INFO,
			PlaceFileTitle.PLACE_FILE_TITLE,
			SchemaVersion.SCHEMA_VERSION,
			Student.STUDENT,
			StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO,
			SystemInform.SYSTEM_INFORM,
			Teacher.TEACHER,
			TeacherCourseTimetableInfo.TEACHER_COURSE_TIMETABLE_INFO,
			TeachCourseInfo.TEACH_COURSE_INFO,
			TeachTaskContent.TEACH_TASK_CONTENT,
			TeachTaskInfo.TEACH_TASK_INFO,
			TeachTaskTitle.TEACH_TASK_TITLE,
			TeachType.TEACH_TYPE,
			Tie.TIE,
			TieElegant.TIE_ELEGANT,
			TieElegantTime.TIE_ELEGANT_TIME,
			TieNotice.TIE_NOTICE,
			TieNoticeAffix.TIE_NOTICE_AFFIX,
			TieNoticeTime.TIE_NOTICE_TIME,
			Users.USERS,
			UserType.USER_TYPE,
			Yard.YARD);
	}
}
