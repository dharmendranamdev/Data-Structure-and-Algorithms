#include<GL/glut.h>
void myinit(void)
{
 glClearColor(1.0,1.0,1.0,0.0);
 glMatrixMode(GL_PROJECTION);
 gluOrtho2D (0.0,200.0,0.0,150.0);
 }

 void lineSegment(void)
 {
glClear(GL_COLOR_BUFFER_BIT);
glColor3f(0.0,0.4,0.2);
glLineWidth(10);
glBegin(GL_LINES);
                  glVertex2i(0,0);
                  glVertex2i(300,300);

glEnd();
glFlush();
}
int main(int argc,char** argv)
{
glutInit(&argc,argv);
glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
glutInitWindowPosition(50,100);
glutInitWindowSize(300,300);
glutCreateWindow("An Example on Open Gl");
myinit();
glutDisplayFunc(lineSegment);
glutMainLoop();
}
