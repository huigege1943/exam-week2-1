# Intent �� flags �б����

## Intent���ֳ�����flags��

**FLAG_ACTIVITY_NEW_TASK**

��Intent�������������ʱ��ϵͳ��Ѱ�һ򴴽�һ���µ�task������Ŀ��Activity��Ѱ��ʱ����Ŀ��Activity��taskAffinity���Խ���ƥ�䣬����ҵ�һ��task��taskAffinity��֮��ͬ���ͽ�Ŀ��Activityѹ���task�У���������޹����򴴽�һ���µ�task��������task��taskAffinity����ΪĿ��Activity��taskActivity����Ŀ��Activity�����ڴ�task��

**FLAG_ACTIVITY_CLEAR_TOP**

��Intent�������������ʱ�������ջ�з��ִ���Activityʵ������������ʵ��֮�ϵ�Activity��ʹ�䴦��ջ����

**FLAG_ACTIVITY_SINGLE_TOP**

��task�д���Ŀ��Activityʵ������λ��ջ�Ķ���ʱ�����ٴ���һ���µģ�ֱ���������ʵ����

**FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET**

���һ��Intent�а��������ԣ�����ת����Ǹ�Activity�Լ����Ǹ�Activity���ϵ�����Activity������task����ʱ�������task�������ǽ�һ����̨��task���»ص�ǰ̨ʱ��ϵͳ�����ض������Ϊ�����������һ��FLAG_ACTIVITY_RESET_TASK_IF_NEEDED��ǣ���ζ�ű�Ҫʱ����task����ʱFLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET�ͻ���Ч���������Է��֣�����һ�����ں�̨��Ӧ�ã��������ѡ�����Ӧ�ã���������к���FLAG_ACTIVITY_RESET_TASK_IF_NEEDED��ǣ�����Home����Ȼ���������¼�������������FLAG_ACTIVITY_RESET_TASK_IF_NEEDED���,����ǰ�߻���������߲��ᡣ

**FLAG_ACTIVITY_RESET_TASK_IF_NEEDED**

����������������»���Ч��1.����Activityʱ�����µ�task������Activityʵ����2.�Ѵ��ڵ�task��������ǰ̨��ϵͳ�����affinity��ָ����task�������ò�����task��ѹ��ĳЩActivityʵ�����Ƴ�ĳЩActivityʵ����