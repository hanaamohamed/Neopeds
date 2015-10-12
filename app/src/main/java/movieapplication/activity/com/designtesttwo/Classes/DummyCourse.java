package movieapplication.activity.com.designtesttwo.Classes;

/**
 * Created by hanaa mohamed on 28-Sep-15.
 */
public class DummyCourse {
    String courseName;
    int CourseIcon;

    public DummyCourse(int courseIcon, String courseName) {
        CourseIcon = courseIcon;
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCoruseIcon() {
        return CourseIcon;
    }

    public void setCoruseIcon(int coruseIcon) {
        CourseIcon = coruseIcon;
    }
}
